package com.spreadsheet;
 
import com.spreadsheet.services.ProcessService;

public class SpreadsheetSimulator {

	public static void main(String[] args) {
		ProcessService processService = new ProcessService();
		processService.runProcessSpreadsheet();
	}

}
