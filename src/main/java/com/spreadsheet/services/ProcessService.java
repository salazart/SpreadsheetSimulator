package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class ProcessService {
	private SpreadsheetService spreadsheetService = new SpreadsheetService();
	private NumericService numericService = new NumericService();
	private CalculationService calculationService = new CalculationService();
	private Spreadsheet spreadsheet;
	
	public ProcessService(Spreadsheet spreadsheet){
		this.spreadsheet = spreadsheet;
	}
	
	public Spreadsheet processSpreadsheet(){
		
		for(int i = 0; i < spreadsheet.getCountRows(); i++){
			for(int j = 0; j < spreadsheet.getCountCells(i); j++){
				CellsDataFactory cellsDataFactory = new CellsDataFactory();
				String dataOfCell = cellsDataFactory.getOutCellsData(spreadsheet.getValue(i, j));
				
				if(isExtension(dataOfCell)){
					dataOfCell = processExtension(dataOfCell);
				}
				
				spreadsheet.setValue(dataOfCell, i, j);
			}
		}
		return spreadsheet;
	}
	
	private String processExtension(String inCellsData){
		if(numericService.isNumeric(inCellsData)){
			return inCellsData;
		} else if (isExtension(inCellsData)){
			String[] cellsElements = getValues(inCellsData);
			String[] operations = getOperations(inCellsData);
			
			String[] cellsNumbers = getValuesOfCells(cellsElements);
			
			return calculationService.calculateExtension(cellsNumbers, operations, inCellsData);
			
		} else {
			return "#" + inCellsData;
		}
		
	}
	
	private String[] getValuesOfCells(String[] cellsElements){
		for(int i = 0; i < cellsElements.length; i++){
			if (numericService.isNumeric(cellsElements[i])){
				continue;
			} else if(spreadsheetService.isSpreadsheetsAdress(cellsElements[i])){
				String value = spreadsheetService.getSpreadsheetsValue(spreadsheet, cellsElements[i]);
				cellsElements[i] = processExtension(value);
				
			} else {
				return new String[0];
			}
		}
		return cellsElements;
	}
	
	private boolean isExtension(String dataOfCell){
		String EQUAL_CHARACTER = "=";
		if(dataOfCell.isEmpty() || !dataOfCell.substring(0, 1).equals(EQUAL_CHARACTER)){
			return false;
		} else {
			return true;
		}
	}
	
	private String[] getValues(String inCellsData){
		String lineValues = inCellsData.replaceAll("[-,+,*,/,=]+"," ");
		lineValues = lineValues.trim();
		return lineValues.split(" ");
	}
	
	private String[] getOperations(String inCellsData){
		String lineOperations = inCellsData.replaceAll("[A-Z,0-9]+"," ");
		lineOperations = lineOperations.trim();
		return lineOperations.split(" ");
	}
}
