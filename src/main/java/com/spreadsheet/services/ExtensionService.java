package com.spreadsheet.services;

import com.spreadsheet.interfaces.CellsData;

public class ExtensionService implements CellsData{
	
	public String getOutCellsData(String inCellsData) {
		//if(inCellsData.isEmpty()){
		//	return inCellsData;
		//} else {
		//	processingExtension(inCellsData.substring(1));
		//}
		return inCellsData;
	}
	
	private void processingExtension(String inCellsData){
		System.out.println(inCellsData);
		String value = new String();
		for(int i = 0; i < inCellsData.length(); i++){
			char q = inCellsData.charAt(i);
			//i
		}
	}
	
	private boolean isCalculateOperation(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		} else {
			return false;
		}
	}
	
}
