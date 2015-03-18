package com.spreadsheet.services;

import com.spreadsheet.interfaces.DataType;

public class NumericService implements DataType{
	private static final String ERROR_CHARACTER = "#";

	public boolean isNumeric(String value){
		if(value.isEmpty() || !value.matches("-?\\d+(\\.\\d+)?")){
			return false;
		} else {
			return true;
		}
	}

	public String[][] getProcessedSpreadsheet(String[][] spreadsheetData,
			int indexheight, int indexLenght) {
		
		if(isNumeric(spreadsheetData[indexheight][indexLenght])){
			return spreadsheetData;
		} else {
			spreadsheetData[indexheight][indexLenght] = ERROR_CHARACTER + spreadsheetData[indexheight][indexLenght];
			return spreadsheetData;
		}
		
	}
}
