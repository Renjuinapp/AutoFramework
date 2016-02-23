package com.org.mavenStudy.DDT;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ExcelRead {
	static Sheet wrkSheet;
	static Workbook wrkBook=null;
	static Hashtable dict = new Hashtable();

	
public ExcelRead(String excelPath) throws BiffException, IOException{
	wrkBook=Workbook.getWorkbook(new File(excelPath));
	wrkSheet=wrkBook.getSheet("sheet1");
}

public static int rowCount(){
	return wrkSheet.getRows();
			
}

public static String readcell(int col,int row){
	return wrkSheet.getCell(col, row).getContents();
	
}

public static void colDictionary(){
	for(int col=0;col<wrkSheet.getColumns();col++){
		dict.put(readcell(col, 0), col);
	}
	
}
public static int getCell(String colname){
	try {
		int value;
		value=((Integer)dict.get(colname)).intValue();
		return value;
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		return(0);
	}
}
}
