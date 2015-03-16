package com.spreadsheet.services;

import com.spreadsheet.interfaces.CellsData;

public class TextValueService implements CellsData{

	public String getOutCellsData(String inCellsData) {
		return inCellsData.substring(1);
	}
	
}
