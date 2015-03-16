package com.spreadsheet.models;

import java.util.ArrayList;
import java.util.List;


public class Spreadsheet{
	private List<SpreadsheetsRow> rows = new ArrayList<SpreadsheetsRow>();

	public boolean isEmpty(){
		if(rows.isEmpty() || rows.size() == 0){
			return true;
		} else {
			return false;
		}
	}
	
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
	
	public void addNewRow(SpreadsheetsRow row){
		rows.add(row);
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
	
	public void addNewCell(String valueCell){
		int currentIndex = rows.size();
		if(currentIndex == 0){
			rows.add(new SpreadsheetsRow());
			rows.get(currentIndex).addNewCell(valueCell);
		} else {
			rows.get(currentIndex-1).addNewCell(valueCell);
		}
		
	}
	
	public List<SpreadsheetsRow> getRows() {
		return rows;
	}

	public void setRows(List<SpreadsheetsRow> rows) {
		this.rows = rows;
	}
}
