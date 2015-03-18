package com.spreadsheet.services;

import com.spreadsheet.interfaces.DataType;
/**
 * This class processing the found extension
 * @author home
 *
 */
public class ExtensionService implements DataType{
	private static final String EXTENSION_CHARACTER = "=";
	private static final String ERROR_CHARACTER = "#";
	
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
	 * @param dataOfCell
	 * @return
	 */
	private String processExtension(String dataOfCell){
		if(numericService.isNumeric(dataOfCell)){
			return dataOfCell;
		} else if (isExtension(dataOfCell)){
			String[] cellsElements = getValues(dataOfCell);
			String[] operations = getOperations(dataOfCell);
			
			String[] cellsNumbers = processExtensionAdress(cellsElements);
			
			return calculationService.calculateExtension(cellsNumbers, operations, dataOfCell);
			
		} else {
			return ERROR_CHARACTER + dataOfCell;
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
				String processedValue = processExtension(spreadsheet[indexHeight][indexLenght]);
				cellsElements[i] = processedValue;
				spreadsheet[indexHeight][indexLenght] = processedValue;
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
		if(extension.isEmpty() || !extension.substring(0, 1).equals(EXTENSION_CHARACTER)){
			return false;
		} else {
			return true;
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
