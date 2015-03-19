package com.spreadsheet.services;

public class DataFactory {
	private static final String TEXT_CHARACTER = "'";
	private static final String EXTENSION_CHARACTER = "=";
	private static final String ERROR_CHARACTER = "#";
	private static final String EMPTY_CHARACTER = "";
	
	public String[][] processFactory(String[][] spreadsheet, int heightData, int lenghtData){
		for(int i = 0; i < heightData; i++){
			for(int j = 0; j < lenghtData; j++){
				spreadsheet = selectFactory(spreadsheet, i, j);
			}
		}
		return spreadsheet;
	}
	
	public String[][] selectFactory(String[][] spreadsheet, int indexheight, int indexLenght){
		
		switch (getFirstSymbol(spreadsheet[indexheight][indexLenght])) {
		case TEXT_CHARACTER:
			return new TextValueService().getProcessedSpreadsheet(spreadsheet, indexheight, indexLenght);
		case EXTENSION_CHARACTER:
			return new ExtensionService().getProcessedSpreadsheet(spreadsheet, indexheight, indexLenght);
		case ERROR_CHARACTER:
			return spreadsheet;
		case EMPTY_CHARACTER:
			return spreadsheet;
		default:
			return new NumericService().getProcessedSpreadsheet(spreadsheet, indexheight, indexLenght);
		}
	}
	
	private String getFirstSymbol(String value){
		if(value == null || value.isEmpty()){
			return new String();
		} else {
			return value.substring(0, 1);
		}
	}
}
