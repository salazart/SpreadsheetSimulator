package com.spreadsheet.services;

import com.spreadsheet.interfaces.DataType;
/**
 * This class processing the found extension
 * @author home
 *
 */
public class ExtensionService implements DataType{
	private static final String EXTENSION_CHARACTER = "=";
	
	private NumericService numericService = new NumericService();
	private CalculationService calculationService = new CalculationService();
	private SpreadsheetService spreadsheetService = new SpreadsheetService();
	
	private String[][] spreadsheet;
	private int startHeight;
	private int startLenght;
	
	public String[][] getProcessedSpreadsheet(String[][] spreadsheet,
			int indexHeight, int indexLenght) {
		this.spreadsheet = spreadsheet;
		this.startHeight = indexHeight;
		this.startLenght = indexLenght;
		
		this.spreadsheet[indexHeight][indexLenght] = processExtension(this.spreadsheet[indexHeight][indexLenght]);
		
		return this.spreadsheet;
	}
	
	/**
	 * Processing extension
	 * @param dataValue
	 * @return
	 */
	private String processExtension(String dataValue){
		if(numericService.isNumeric(dataValue)){
			return dataValue;
		} else if (isExtension(dataValue)){
			String[] cellsElements = calculationService.getValues(dataValue);
			String[] operations = calculationService.getOperations(dataValue);
			
			String[] cellsNumbers = processExtensionAdress(cellsElements);
			
			return calculationService.calculateExtension(cellsNumbers, operations, dataValue);
			
		} else {
			return numericService.errorExtension(dataValue);
		}
		
	}
	
	/**
	 * Processing all elements of extension and returning array decimal value for calculating
	 * @param cellsElements
	 * @return
	 */
	private String[] processExtensionAdress(String[] cellsElements){
		for(int i = 0; i < cellsElements.length; i++){
			if(spreadsheetService.isCorrectAdress(cellsElements[i])){
				
				int indexHeight = spreadsheetService.getIndexHeigh();
				int indexLenght = spreadsheetService.getIndexLenght();

				// Exit from recursion, when found iteration extension 
				if(indexHeight == this.startHeight && indexLenght == this.startLenght)
					return cellsElements;
				
				//Recursion 
				cellsElements[i] = processExtension(spreadsheet[indexHeight][indexLenght]);
			}
		}
		return cellsElements;
	}
	
	
	/**
	 * Check extension
	 * @param extension
	 * @return
	 */
	public boolean isExtension(String extension){
		if(extension.isEmpty() || !extension.startsWith(EXTENSION_CHARACTER)){
			return false;
		} else {
			return true;
		}
	}
	

}
