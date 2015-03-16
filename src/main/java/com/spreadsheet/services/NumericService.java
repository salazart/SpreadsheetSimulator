package com.spreadsheet.services;

import com.spreadsheet.interfaces.CellsData;

public class NumericService implements CellsData{
	private static final String ERROR_CHARACTER = "#";

	public String getOutCellsData(String inCellsData) {
		if(isNumeric(inCellsData)){
			return inCellsData;
		} else {
			return ERROR_CHARACTER + inCellsData;
		}
	}
	
	public boolean isNumeric(String inCellsData){
		if(inCellsData.matches("-?\\d+(\\.\\d+)?")){
			return true;
		} else {
			return false;
		}
	}
}
