package com.spreadsheet.services;

import com.spreadsheet.interfaces.DataType;

/**
 * Class check numeric value and if false returning error extension  
 * @author home
 *
 */
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
			spreadsheetData[indexheight][indexLenght] = errorExtension(spreadsheetData[indexheight][indexLenght]);
			return spreadsheetData;
		}
		
	}
	
	/**
	 * returning error extension
	 * @param originValue
	 * @return
	 */
	public String errorExtension(String originValue){
		if(originValue.startsWith(ERROR_CHARACTER)){
			return originValue;
		} else {
			return ERROR_CHARACTER + originValue;
		}
	}
}
