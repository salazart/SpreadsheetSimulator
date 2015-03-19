package com.spreadsheet.services;

import java.util.Scanner;

/**
 * The class read input data in the form:
 * first line contains values of the count rows and columns data
 * second lines contains a data values separated tabulate symbol 
 * @author home
 *
 */
public class InputDataService {
	private static final String SEPARATE_SYMBOL = "\t";
	private Scanner scanner = new Scanner(System.in);
	private int heightData;
	private int lenghtData;
	
	/**
	 * Method read input data from System.in
	 * @return array with input data
	 */
	public String[][] readInputData(){
		String[] rowInputData = getInputElements();
		heightData = Integer.valueOf(rowInputData[0]);
		lenghtData = Integer.valueOf(rowInputData[1]);
		
		String[][] inputData = new String[heightData][lenghtData];
		
		for(int i = 0; i < heightData; i++){
			rowInputData = getInputElements();
			inputData = addRowInputData(inputData, rowInputData, i);
		}
		scanner.close();
		return inputData;
	}
	
	/**
	 * Adding new row with elements into inputData
	 * @param inputData = main array input data
	 * @param rowInputData = row that adding
	 * @param indexHeightData = index the adding row
	 * @return
	 */
	private String[][] addRowInputData(String[][] inputData, 
			String[] rowInputData, int indexHeightData){
		
		for(int j = 0; j < lenghtData; j++){
			inputData[indexHeightData][j] = rowInputData[j];
		}
		return inputData;
	}
	
	/**
	 * return next line form System.in
	 * @return
	 */
	private String[] getInputElements(){
		String lineInputData = scanner.nextLine();
		String[] inputElements = lineInputData.split(SEPARATE_SYMBOL);
		return inputElements;
	}
				
	
	public int getHeightData() {
		return heightData;
	}

	public int getLenghtData() {
		return lenghtData;
	}
}
