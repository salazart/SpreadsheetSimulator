package com.spreadsheet;
 
import com.spreadsheet.services.ProcessService;

public class SpreadsheetSimulator {

	public static void main(String[] args) {
		ProcessService processService = new ProcessService();
		processService.runProcessSpreadsheet();
		
		//ProcessService processService = new ProcessService(inSpreadsheet);
		//Spreadsheet outSpreadsheet = processService.processSpreadsheet();
		
		//OutDataService writeOutData = new OutDataService();
		//writeOutData.writeOutData(outSpreadsheet);
		
	}

}
