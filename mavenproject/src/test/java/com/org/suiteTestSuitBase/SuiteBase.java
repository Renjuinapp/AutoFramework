package com.org.suiteTestSuitBase;


import java.io.IOException;
import com.org.framework.DDT.Read_XLS;

public class SuiteBase {	
	public static Read_XLS TestSuiteListExcel=null;
	public static Read_XLS RegressionSuiteListExcel =null;
	
	
	public  void  init() throws IOException{
		
		//Initializing Test Suite List(TestSuiteList.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestSuiteListExcel = new Read_XLS(System.getProperty("user.dir")+"\\src\\main\\java\\com\\org\\framework\\Excelfiles\\TestSuiteList.xls");
		//Initializing Test Suite One(RegressionSuite.xls) File Path Using Constructor Of Read_XLS Utility Class.
		RegressionSuiteListExcel = new Read_XLS(System.getProperty("user.dir")+"\\src\\main\\java\\com\\org\\framework\\Excelfiles\\RegressionSuite.xls");
		
	}	
}
