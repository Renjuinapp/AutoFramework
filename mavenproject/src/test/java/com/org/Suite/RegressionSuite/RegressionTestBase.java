package com.org.Suite.RegressionSuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.org.framework.DDT.Read_XLS;
import com.org.framework.DDT.SuiteUtility;
import com.org.framework.Util.PropertyUtil;
import com.org.suiteTestSuitBase.SuiteBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegressionTestBase extends SuiteBase  {

	public static ExtentTest    log; 
	private static ExtentReports extent;
	public String ToRunColumnNameTestCase = "CaseToRun";
	Read_XLS FilePath = null;
	String TestCaseName = null;
	String SheetName = null;
	String SuiteName = null;
	String ToRunColumnName = null;	
	
	@BeforeSuite
	public void checkSuiteToRun() throws IOException{
		//Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		//To set TestSuiteList.xls file's path In FilePath Variable.
		FilePath = TestSuiteListExcel;
		SheetName = "SuitesList";
		SuiteName = "RegressionSuite";
		ToRunColumnName = "SuiteToRun";
		//If SuiteToRun !== "y" then SuiteOne will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnName,SuiteName)){	
			//Writing Skip info to the TestsuiteList Excel
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Skipped");
			//It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName);
		}else{
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Executed");
		}
		init();	
		FilePath = RegressionSuiteListExcel;
		
			

	}
	
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Entered to After Suites>>>>>>>>>>>>>>>>>>>>>>>");
		driver.quit();
	}
	
}
