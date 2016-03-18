package com.org.Suite.RegressionSuite;

import java.io.IOException;

import junit.framework.Assert;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.framework.DDT.Read_XLS;
import com.org.framework.DDT.SuiteUtility;
import com.org.framework.ObjRepo.LoginpageObject;
import com.relevantcodes.extentreports.LogStatus;

//SuiteOneCaseOne Class Inherits From SuiteOneBase Class.
//So, SuiteOneCaseOne Class Is Child Class Of SuiteOneBase Class And SuiteBase Class.
public class Testcase002 extends RegressionTestBase{
	Read_XLS FilePath = null;	
	String TestCaseName = null;	
	@BeforeClass
	public void getTestcaseName() {
		FilePath = RegressionSuiteListExcel;
		SheetName = "TestCasesList";
		TestCaseName = this.getClass().getSimpleName();
		ToRunColumnNameTestCase = "CaseToRun";
		//log = reports.startTest(TestCaseName);
		if (!SuiteUtility.checkToRunUtility(FilePath, SheetName,
				ToRunColumnNameTestCase, TestCaseName)) {
			//log.log(LogStatus.INFO, "Flag is N");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "Skipped");
			driver.quit();
			throw new SkipException(
					TestCaseName
							+ "'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "
							+ TestCaseName);
			
		}else{
			//driver.navigate().to("http://23.96.61.6/");
			//driver.manage().window().maximize();
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "Executed");
			//log.log(LogStatus.INFO, TestCaseName+"Executed");
		}
	}
	@BeforeTest
	public void checkCaseToRun() throws IOException{
		//Called init() function from SuiteBase class to Initialize .xls Files
		
	}
	
	//Accepts 4 column's String data In every Iteration.
	@Test
	public void Testcase002Test() throws InterruptedException{
		LoginpageObject login =new LoginpageObject();
		login.applogin("demo@reliantparking.com", "reliant1");
		Thread.sleep(4000);
		String title = driver.getTitle();
		System.out.println("Title is >>>>>>>>" + title);
		Assert.assertTrue(title.equals("Testing"));
	}	
	
	//This data provider method will return 4 column's data one by one In every Iteration.
	
}

