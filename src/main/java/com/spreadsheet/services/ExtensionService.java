package com.spreadsheet.services;

import com.spreadsheet.interfaces.CellsData;

public class ExtensionService implements CellsData{
	
	public String getOutCellsData(String inCellsData) {
		return inCellsData;
	}
	
	public boolean isExtension(String dataOfCell){
		String EQUAL_CHARACTER = "=";
		if(dataOfCell.isEmpty() || !dataOfCell.substring(0, 1).equals(EQUAL_CHARACTER)){
			return false;
		} else {
			return true;
		}
	}
	
	public String[] getValues(String inCellsData){
		String lineValues = inCellsData.replaceAll("[-,+,*,/,=]+"," ");
		lineValues = lineValues.trim();
		return lineValues.split(" ");
	}
	
	public String[] getOperations(String inCellsData){
		String lineOperations = inCellsData.replaceAll("[A-Z,0-9]+"," ");
		lineOperations = lineOperations.trim();
		return lineOperations.split(" ");
	}
}
