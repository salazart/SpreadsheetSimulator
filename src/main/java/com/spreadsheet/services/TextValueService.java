package com.spreadsheet.services;

import com.spreadsheet.interfaces.DataType;

public class TextValueService implements DataType{

	public String[][] getProcessedSpreadsheet(String[][] spreadsheet,
			int indexheight, int indexLenght) {
		
		String value = spreadsheet[indexheight][indexLenght];
		
		if(value != null && !value.isEmpty()){
			spreadsheet[indexheight][indexLenght] = value.substring(1);
		}
		return spreadsheet;
	}
	
}
