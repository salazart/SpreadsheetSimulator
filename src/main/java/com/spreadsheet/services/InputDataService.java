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
	private Scanner scanner = new Scanner(System.in);
	private int heightData;
	private int lenghtData;
	
	public String[][] readInputData(){
		heightData = scanner.nextInt();
		lenghtData = scanner.nextInt();

		String[][] inputData = new String[heightData][lenghtData];
		
		for(int i = 0; i < heightData; i++){
			for(int j = 0; j < lenghtData; j++){
				inputData[i][j] = scanner.next();
			}
		}
		scanner.close();
		return inputData;
	}

	public int getHeightData() {
		return heightData;
	}

	public int getLenghtData() {
		return lenghtData;
	}
}
