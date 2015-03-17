package com.spreadsheet.services;

public class CellsDataFactory {
	private static final String QUOTE_CHARACTER = "'";
	private static final String EQUAL_CHARACTER = "=";
	private static final String ERROR_CHARACTER = "#";
	
	
	public String getOutCellsData(String inCellsData){
		
		if(inCellsData.isEmpty()){
			return inCellsData;
		} else {
			switch (inCellsData.substring(0, 1)) {
			case QUOTE_CHARACTER:
				return new TextValueService().getOutCellsData(inCellsData);
			case EQUAL_CHARACTER:
				return new ExtensionService().getOutCellsData(inCellsData);
			case ERROR_CHARACTER:
				return inCellsData;
			default:
				return new NumericService().getOutCellsData(inCellsData);
			}
		}
	}
}
