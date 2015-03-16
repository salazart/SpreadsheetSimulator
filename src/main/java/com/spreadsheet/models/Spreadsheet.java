package com.spreadsheet.models;

import java.util.ArrayList;
import java.util.List;


public class Spreadsheet{
	private List<SpreadsheetsRow> rows = new ArrayList<SpreadsheetsRow>();

	public List<String> getCells(int indexRow){
		if(indexRow < getCountRows()){
			return rows.get(indexRow).getCells();
		} else {
			return new ArrayList<String>();
		}
		
	}
	
	public int getCountRows(){
		return rows.size();
	}
	
	public int getCountCells(int indexRow){
		if(indexRow < getCountRows()){
			return rows.get(indexRow).getCells().size();
		} else {
			return 0;
		}
	}
	
	public void addNewRow(List<String> row){
		SpreadsheetsRow spreadsheetsRow = new SpreadsheetsRow();
		spreadsheetsRow.setCell(row);
		rows.add(spreadsheetsRow);
	}
	
	public String getValue(int indexRow, int indexCell){
		if(indexRow < getCountRows()){
			if(indexCell < getCountCells(indexRow)){
				return rows.get(indexRow).getCells().get(indexCell);
			}
		}
		return new String();
	}
	
	public void setValue(String value, int indexRow, int indexCell){
		if(indexRow < getCountRows()){
			if(indexCell < getCountCells(indexRow)){
				rows.get(indexRow).getCells().set(indexCell, value);
			}
		}
	}
}
