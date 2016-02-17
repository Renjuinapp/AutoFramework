package com.org.mavenStudy.DDT;

import java.io.File;

import jxl.Workbook;



public class ExcelRead {

	Workbook wrkBook = null;

	public ExcelRead(String Path) {
		try {
			wrkBook = Workbook.getWorkbook(new File(Path));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
