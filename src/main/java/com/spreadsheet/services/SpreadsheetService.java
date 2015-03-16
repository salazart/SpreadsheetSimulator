package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class SpreadsheetService {
	private static final int BYTE_CODE_A = 64;
	
	public String getSpreadsheetsValue(Spreadsheet spreadsheet, String adressValue){
		if(isSpreadsheetsAdress(adressValue)){
			int indexRow = getIndexRow(adressValue);
			int indexColumn = getIndexColumn(adressValue);
			return spreadsheet.getValue(indexRow, indexColumn);
		} else {
			return new String();
		}
	}
	
	private int getIndexRow(String adressValue){
		String indexRowText = adressValue.replaceAll("[^0-9]+","");
		if(!indexRowText.isEmpty()){
			return Integer.valueOf(indexRowText)-1;
		} else {
			return 0;
		}
	}
	
	private int getIndexColumn(String adressValue){
		String indexColumnText = adressValue.replaceAll("[^A-Z]+","");
		int indexColumn = 0;
		if(indexColumnText.isEmpty()){
			return 0;
		} else {
			
			for(int i = indexColumnText.length()-1; i >= 0; i--){
				char charSymbol = indexColumnText.charAt(i);
				byte b = (byte)charSymbol;
				int currentIndexColumn = b - BYTE_CODE_A;
				
				int numberPower = (indexColumnText.length()-1 - i);
				numberPower = (int) Math.pow(26, numberPower);
				
				indexColumn = indexColumn + currentIndexColumn * numberPower;
			}
		}
		return indexColumn-1;
	}
	
	public boolean isSpreadsheetsAdress(String adressValue){
		boolean flagText = false;
		boolean flagDigital = false;
		for(int i = 0; i < adressValue.length(); i++){
			char charSymbol = adressValue.charAt(i);
			if(charSymbol >= 'A' && charSymbol <='Z' && flagDigital == false){
				flagText = true;
				continue;
			} else if(charSymbol >= '0' && charSymbol <= '9' && flagText == true){
				flagDigital = true;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
