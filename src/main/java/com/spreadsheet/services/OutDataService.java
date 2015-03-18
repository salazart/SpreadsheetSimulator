package com.spreadsheet.services;

/**
 * The class write out data in the form table data values separated tabulate symbol 
 * @author home
 *
 */

public class OutDataService {
	private static final String DELIMITER_SYMBOL = "\t";
	
	public void writeOutData(String[][] outData, int heightData, int lenghtData){
		for(int i = 0; i < heightData; i++){
			for(int j = 0; j < lenghtData-1; j++){
				System.out.print(outData[i][j] + DELIMITER_SYMBOL);
			}
			System.out.println(outData[i][lenghtData-1]);
		}
	}
	
}
