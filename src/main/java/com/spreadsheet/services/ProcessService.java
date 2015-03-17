package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class ProcessService {
	private SpreadsheetService spreadsheetService = new SpreadsheetService();
	private ExtensionService extensionService = new ExtensionService();
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
				
				if(extensionService.isExtension(dataOfCell)){
					dataOfCell = processExtension(dataOfCell);
				}
				
				spreadsheet.setValue(dataOfCell, i, j);
			}
		}
		return spreadsheet;
	}
	
	private String processExtension(String dataOfCell){
		if(numericService.isNumeric(dataOfCell)){
			return dataOfCell;
		} else if (extensionService.isExtension(dataOfCell)){
			String[] cellsElements = extensionService.getValues(dataOfCell);
			String[] operations = extensionService.getOperations(dataOfCell);
			
			String[] cellsNumbers = getValuesOfCells(cellsElements);
			
			return calculationService.calculateExtension(cellsNumbers, operations, dataOfCell);
			
		} else {
			return "#" + dataOfCell;
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
}
