package com.spreadsheet;

import com.spreadsheet.models.Spreadsheet;
import com.spreadsheet.services.ReadInputData;
import com.spreadsheet.services.SpreadsheetService;

public class SpreadsheetSimulator {

	public static void main(String[] args) {
		ReadInputData readInputData = new ReadInputData();
		Spreadsheet spreadsheet = readInputData.readInputData();
			
		String adressValue = "B1";
		SpreadsheetService spreadsheetService = new SpreadsheetService();
		System.out.println(spreadsheetService.getSpreadsheetsValue(spreadsheet, adressValue));
		
		//WriteOutData writeOutData = new WriteOutData();
		//writeOutData.writeOutData(spreadsheet);
		
	}

}
