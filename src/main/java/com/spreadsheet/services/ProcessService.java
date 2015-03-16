package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class ProcessService {
	private SpreadsheetService spreadsheetService = new SpreadsheetService();
	private NumericService digitalService = new NumericService();
	private CalculationService calculationService = new CalculationService();
	private Spreadsheet spreadsheet;
	
	public ProcessService(Spreadsheet spreadsheet){
		this.spreadsheet = spreadsheet;
	}
	
	public Spreadsheet processSpreadsheet(){
		
		for(int i = 0; i < spreadsheet.getCountRows(); i++){
			for(int j = 0; j < spreadsheet.getCountCells(i); j++){
				CellsDataFactory cellsDataFactory = new CellsDataFactory();
				String outCellsData = cellsDataFactory.getOutCellsData(spreadsheet.getValue(i, j));
				
				if(isExtension(outCellsData)){
					outCellsData = processExtension(outCellsData);
				}
				
				spreadsheet.setValue(outCellsData, i, j);
			}
		}
		return spreadsheet;
	}
	
	private String processExtension(String inCellsData){
		if(digitalService.isNumeric(inCellsData)){
			return inCellsData;
		} else {
			String[] cellsElements = getValues(inCellsData);
			String[] operations = getOperations(inCellsData);
			
			cellsElements = getValuesOfCells(cellsElements);
			
			return calculationService.calculateExtension(cellsElements, operations);
		}
		
	}
	
	private String[] getValuesOfCells(String[] cellsElements){
		for(int i = 0; i < cellsElements.length; i++){
			if(spreadsheetService.isSpreadsheetsAdress(cellsElements[i])){
				String value = spreadsheetService.getSpreadsheetsValue(spreadsheet, cellsElements[i]);
				cellsElements[i] = processExtension(value);
			} else {
				continue;
			}
		}
		return cellsElements;
	}
	
	private boolean isExtension(String outCellsData){
		String EQUAL_CHARACTER = "=";
		if(outCellsData.substring(0, 1).equals(EQUAL_CHARACTER)){
			return true;
		} else {
			return false;
		}
	}
	
	private String[] getValues(String inCellsData){
		String lineValues = inCellsData.replaceAll("[^0-9,^A-Z]+"," ");
		lineValues = lineValues.trim();
		return lineValues.split(" ");
	}
	
	private String[] getOperations(String inCellsData){
		String lineOperations = inCellsData.replaceAll("[^-,^+,^*,^/]+"," ");
		lineOperations = lineOperations.trim();
		return lineOperations.split(" ");
	}
}
