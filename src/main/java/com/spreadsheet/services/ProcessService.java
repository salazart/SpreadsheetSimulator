package com.spreadsheet.services;


public class ProcessService {
	private InputDataService inputDataService = new InputDataService();
	private OutDataService outDataService = new OutDataService();
	private DataFactory cellsDataFactory = new DataFactory();
	
	public void runProcessSpreadsheet(){
		String[][] inData = inputDataService.readInputData();
		int heightData = inputDataService.getHeightData();
		int lenghtData = inputDataService.getLenghtData();
		
		String[][] outData = cellsDataFactory.processFactory(inData, heightData, lenghtData);
		
		outDataService.writeOutData(outData, heightData, lenghtData);
	}
	
	
}
