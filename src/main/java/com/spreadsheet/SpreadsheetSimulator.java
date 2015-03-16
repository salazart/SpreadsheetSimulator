package com.spreadsheet;
 
import com.spreadsheet.models.Spreadsheet;
import com.spreadsheet.services.ProcessService;
import com.spreadsheet.services.ReadInputData;
import com.spreadsheet.services.WriteOutData;

public class SpreadsheetSimulator {

	public static void main(String[] args) {
		ReadInputData readInputData = new ReadInputData();
		Spreadsheet inSpreadsheet = readInputData.readInputData();
			
		ProcessService processService = new ProcessService(inSpreadsheet);
		Spreadsheet outSpreadsheet = processService.processSpreadsheet();
		
		//String adressValue = "C3";
		//SpreadsheetService spreadsheetService = new SpreadsheetService();
		//System.out.println(spreadsheetService.getSpreadsheetsValue(inSpreadsheet, adressValue));
		
		WriteOutData writeOutData = new WriteOutData();
		writeOutData.writeOutData(outSpreadsheet);
		
	}

}
