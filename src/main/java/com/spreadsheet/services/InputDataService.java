package com.spreadsheet.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.spreadsheet.models.Spreadsheet;

public class InputDataService {
	private static final String SEPARATE_SYMBOL = "\t";
	private Scanner scanner = new Scanner(System.in);
	private int height;
	private int lenght;
	
	public Spreadsheet readInputData(){
		
		Spreadsheet spreadsheet = new Spreadsheet();
		if(!sizeSpeadsheet()){
			return spreadsheet;
		} else {
			for(int i = 0; i < height; i++){
				spreadsheet.addNewRow(getInputElements());
			}
		}
		return spreadsheet;
	}
	
	private boolean sizeSpeadsheet(){
		List<String> inputElements = getInputElements();
		if(inputElements.size() > 1){
			try{
				height = Integer.valueOf(inputElements.get(0));
				lenght = Integer.valueOf(inputElements.get(1));
				return true;
			} catch (Exception e){
				return false;
			}
		}
		return false;
	}
	
	private List<String> getInputElements(){
		if(scanner.hasNextLine()){
			String inputData = scanner.nextLine();
			String[] inputElements = inputData.split(SEPARATE_SYMBOL);
			return Arrays.asList(inputElements);
		} else {
			return new ArrayList<String>();
		}
	}
	
	public int getHeight() {
		return height;
	}

	public int getLenght() {
		return lenght;
	}

}
