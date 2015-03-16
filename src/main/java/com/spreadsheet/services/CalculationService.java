package com.spreadsheet.services;


public class CalculationService{
	private DigitalService digitalService = new DigitalService();
	
	public String calculateExtension(String[] cellsElements, String[] operations) {
		int value = Integer.valueOf(cellsElements[0]);
		for(int i = 0; i < cellsElements.length-1; i++){
			
			switch (operations[i]){
			case "+":
				value = (value + Integer.valueOf(cellsElements[i+1]));
				continue;
			case "-":
				value = (value - Integer.valueOf(cellsElements[i+1]));
				continue;
			case "*":
				value = (value * Integer.valueOf(cellsElements[i+1]));
				continue;
			case "/":
				value = (value / Integer.valueOf(cellsElements[i+1]));
				continue;
			}
		}
		return String.valueOf(Math.round(value));
	}

}
