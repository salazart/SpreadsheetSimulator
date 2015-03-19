package com.spreadsheet.services;


public class CalculationService{
	private NumericService numericService = new NumericService();
	private int firstValue;
	
	public String calculateExtension(String[] cellsNumbers, String[] operations, String originData) {
		if(cellsNumbers.length == 0){
			return numericService.errorExtension(originData);
		} else {
			for(int i = 0; i < cellsNumbers.length; i++){
				if(numericService.isNumeric(cellsNumbers[i])){
					factoryOperation(cellsNumbers[i], operations[i]);
				} else {
					return numericService.errorExtension(originData);
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
	
	/**
	 *	Returning all values from extension for calculate result
	 * @param extension
	 * @return
	 */
	public String[] getValues(String extension){
		String lineValues = extension.replaceAll("[-,+,*,/,=]+"," ");
		lineValues = lineValues.trim();
		return lineValues.split(" ");
	}
	
	/**
	 *	Returning all operations from extension 
	 * @param extension
	 * @return
	 */
	public String[] getOperations(String extension){
		String lineOperations = extension.replaceAll("[A-Z,0-9]+"," ");
		lineOperations = lineOperations.trim();
		return lineOperations.split(" ");
	}
}
