package com.org.Suite.RegressionSuite;

import java.io.IOException;
import java.net.MalformedURLException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.framework.DDT.Read_XLS;
import com.org.framework.DDT.SuiteUtility;
import com.org.framework.ObjRepo.LoginpageObject;
import com.org.framework.ObjRepo.SelectPropertyPageObject;
import com.relevantcodes.extentreports.LogStatus;

//SuiteOneCaseOne Class Inherits From SuiteOneBase Class.
//So, SuiteOneCaseOne Class Is Child Class Of SuiteOneBase Class And SuiteBase Class.
public class Testcase002 extends RegressionTestBase{

	Read_XLS FilePath = null;	
	String TestCaseName = null;
	
		@Parameters({"browser"})
		@BeforeTest
		public void setup(String browser) throws MalformedURLException{
			FilePath = RegressionSuiteListExcel;
			SheetName = "TestCasesList";
			TestCaseName = this.getClass().getSimpleName();
			ToRunColumnNameTestCase = "CaseToRun";
			System.out.println("Test case Name >>>>>>>>>>>"+TestCaseName);

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
				
				SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "Executed");
				loadWebBrowser(browser);
				
			}
		}
		
	
	
	//Accepts 4 column's String data In every Iteration.
	@Test
	public void Testcase002Test() throws Exception{
		System.out.println("<<<<<<<<<<<<<<<<<<<< Entered to the testing parts TWO  >>>>>>>>>>>");
		LoginpageObject login =new LoginpageObject(driver);
		SelectPropertyPageObject selectPropety =login.Managerlogin("demo@reliantparking.com", "reliant1",driver);
		Thread.sleep(4000);
		selectPropety.SwitchToPropety("1 ADD ISSUE");
		
		Thread.sleep(4000);
		String title = driver.getTitle();
		
		System.out.println("Title is >>>>>>>>" + title);
		Assert.assertTrue(title.equals("Testing"));
	}	
	
	@AfterTest
	public void tearDown(){
		closeWebBrowser();
	}
	//This data provider method will return 4 column's data one by one In every Iteration.
	
}

