package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class SpreadsheetService {
	private static final int BYTE_CODE_A = 64;
	private int indexRow;
	private int indexColumn;
	
	public String getSpreadsheetsValue(Spreadsheet spreadsheet, String adressValue){
		indexRow = getIndexRow(adressValue);
		indexColumn = getIndexColumn(adressValue);
		return spreadsheet.getValue(indexRow, indexColumn);
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
}
