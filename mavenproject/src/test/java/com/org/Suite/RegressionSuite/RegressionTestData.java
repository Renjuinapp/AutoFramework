package com.org.Suite.RegressionSuite;

import org.testng.annotations.DataProvider;

import com.org.framework.DDT.Read_XLS;
import com.org.framework.DDT.SuiteUtility;

public class RegressionTestData {

	
	@DataProvider
	public Object[][] Testcase001Data(Read_XLS FilePath,String TestCaseName ){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
		
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}
}
