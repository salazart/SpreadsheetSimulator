package com.spreadsheet.services;


public class CalculationService{
	private NumericService numericService = new NumericService();
	private int firstValue;
	
	public String calculateExtension(String[] cellsNumbers, String[] operations, String originDataCells) {
		if(cellsNumbers.length == 0){
			return "#" + originDataCells;
		} else {
			for(int i = 0; i < cellsNumbers.length; i++){
				if(numericService.isNumeric(cellsNumbers[i])){
					factoryOperation(cellsNumbers[i], operations[i]);
				} else {
					return "#" + originDataCells;//new String();
				}
			}
		}
		return String.valueOf(Math.round(firstValue));
	}
	
	private void factoryOperation(String value, String operation){
		switch (operation){
		case "=":
			firstValue = Integer.valueOf(value);
			break;
		case "+":
			firstValue = firstValue + Integer.valueOf(value);
			break;
		case "-":
			firstValue = firstValue - Integer.valueOf(value);
			break;
		case "*":
			firstValue = firstValue * Integer.valueOf(value);
			break;
		case "/":
			firstValue = firstValue / Integer.valueOf(value);
			break;
		}
	}
}
