package com.spreadsheet;
 
import com.spreadsheet.models.Spreadsheet;
import com.spreadsheet.services.ProcessService;
import com.spreadsheet.services.InputDataService;
import com.spreadsheet.services.OutDataService;

public class SpreadsheetSimulator {

	public static void main(String[] args) {
		InputDataService readInputData = new InputDataService();
		Spreadsheet inSpreadsheet = readInputData.readInputData();
			
		ProcessService processService = new ProcessService(inSpreadsheet);
		Spreadsheet outSpreadsheet = processService.processSpreadsheet();
		
		//String adressValue = "C3";
		//SpreadsheetService spreadsheetService = new SpreadsheetService();
		//System.out.println(spreadsheetService.getSpreadsheetsValue(inSpreadsheet, adressValue));
		
		OutDataService writeOutData = new OutDataService();
		writeOutData.writeOutData(outSpreadsheet);
		
	}

}
