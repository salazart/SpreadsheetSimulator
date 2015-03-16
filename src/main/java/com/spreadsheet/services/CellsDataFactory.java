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
			default:
				if(Character.isDigit(inCellsData.charAt(0))){
					return new NumericService().getOutCellsData(inCellsData);
				} else {
					return ERROR_CHARACTER + inCellsData;
				}
			}
		}
	}
}
