package com.spreadsheet.services;

/**
 * This class convert adress of cell to integer type 
 * @author home
 *
 */
public class SpreadsheetService {
	private static final int BYTE_CODE_A = 64;
	
	private int indexHeigh;
	private int indexLenght;
	
	public boolean isCorrectAdress(String adressValue){
		if(isSpreadsheetsAdress(adressValue)){
			setIndexHeigh(getIndexHeight(adressValue));
			setIndexLenght(getIndexLenght(adressValue));
			return true;
		} else {
			return false;
		}
	}
	
	private int getIndexHeight(String adressValue){
		String indexRowText = adressValue.replaceAll("[^0-9]+","");
		if(!indexRowText.isEmpty()){
			return Integer.valueOf(indexRowText)-1;
		} else {
			return 0;
		}
	}
	
	private int getIndexLenght(String adressValue){
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
	
	private boolean isSpreadsheetsAdress(String adressValue){
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

	public int getIndexHeigh() {
		return indexHeigh;
	}

	private void setIndexHeigh(int indexHeigh) {
		this.indexHeigh = indexHeigh;
	}

	public int getIndexLenght() {
		return indexLenght;
	}

	private void setIndexLenght(int indexLenght) {
		this.indexLenght = indexLenght;
	}
}
