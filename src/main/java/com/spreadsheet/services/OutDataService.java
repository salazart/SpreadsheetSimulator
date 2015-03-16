package com.spreadsheet.services;

import com.spreadsheet.models.Spreadsheet;

public class OutDataService {
	
	public void writeOutData(Spreadsheet spreadsheet){
		for(int i = 0; i < spreadsheet.getCountRows(); i++){
			for(int j = 0; j < spreadsheet.getCountCells(i)-1; j++){
				System.out.print(spreadsheet.getValue(i, j) + "\t");
			}
			System.out.println(spreadsheet.getValue(i, spreadsheet.getCountCells(i)-1));
		}
	}
	
}
