package com.spreadsheet.models;

import java.util.ArrayList;
import java.util.List;

public class SpreadsheetsRow {
	private List<String> cells = new ArrayList<String>();
	
	public void addNewCell(String valueCell){
		cells.add(valueCell);
	}
	
	public void printSpreadsheetsRow(){
		for(int i = 0; i < cells.size(); i++){
			System.out.print(cells.get(i) + "\t");
		}
		System.out.println();
	}
	
	public boolean isEmpty(){
		for(int i = 0; i < cells.size(); i++){
			if(!cells.get(i).isEmpty()){
				return false; 
			}
		}
		return true;
	}
	
	public List<String> getCells() {
		return cells;
	}

	public void setCell(List<String> cell) {
		this.cells = cell;
	}
}
