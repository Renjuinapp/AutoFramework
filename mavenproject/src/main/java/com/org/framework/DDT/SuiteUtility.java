package com.org.framework.DDT;

public class SuiteUtility {	
	
	public static boolean checkToRunUtility(Read_XLS xls, String sheetName, String ToRun, String testSuite){
		return xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("y");	
	}
	
	public static String[] checkToRunUtilityOfData(Read_XLS xls, String sheetName, String ColName){		
		return xls.retrieveToRunFlagTestData(sheetName,ColName);		 	
	}
 
	public static Object[][] GetTestDataUtility(Read_XLS xls, String sheetName){
	 	return xls.retrieveTestData(sheetName);	
	}
 
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, int rowNum, String Result){			
		return xls.writeResult(sheetName, ColName, rowNum, Result);		 	
	}
 
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, String rowName, String Result){			
		return xls.writeResult(sheetName, ColName, rowName, Result);		 	
	}
	
}

