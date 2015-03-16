package com.spreadsheet.services;

import com.spreadsheet.interfaces.CellsData;

public class DigitalService implements CellsData{
	private static final String ERROR_CHARACTER = "#";

	public String getOutCellsData(String inCellsData) {
		
		if(isDigital(inCellsData)){
			return inCellsData;
		} else {
			return ERROR_CHARACTER + inCellsData;
		}
	}
	
	public boolean isDigital(String inCellsData){
		if(inCellsData.isEmpty()){
			return false;
		} else {
			for(int i = 0; i < inCellsData.length(); i++){
				if(!Character.isDigit(inCellsData.charAt(i))){
					return false;
				}
			}
			return true;
		}
	}
}
