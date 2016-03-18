package com.org.Suite.RegressionSuite;

import junit.framework.Assert;

import org.apache.poi.hssf.record.IterationRecord;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.org.framework.DDT.Read_XLS;
import com.org.framework.DDT.SuiteUtility;
import com.org.framework.ObjRepo.Homepageobject;
import com.org.framework.ObjRepo.LoginpageObject;
import com.org.framework.Screenshot.ScreenShots;
import com.relevantcodes.extentreports.LogStatus;

public class Testcase001 extends RegressionTestBase {

	ITestResult result;
	RegressionTestData TestData = new RegressionTestData();
	
	@BeforeClass
	public void getTestcaseName() {
	
			FilePath = RegressionSuiteListExcel;
			SheetName = "TestCasesList";
			TestCaseName = this.getClass().getSimpleName();
			if (!SuiteUtility.checkToRunUtility(FilePath, SheetName,
					ToRunColumnNameTestCase, TestCaseName)) {
			//	log.log(LogStatus.INFO, "Testcase Skipped");
				throw new SkipException(
						TestCaseName
								+ "'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "
								+ TestCaseName);
				
			} else {

				SuiteUtility.WriteResultUtility(FilePath, SheetName,
						"Pass/Fail/Skip", TestCaseName, "Executed");
			}
		
	}

	@Test(dataProvider = "Testcase001Test")
	public void Testcase001Test(String Username, String Password) {
		try {
			
			
			LoginpageObject login = new LoginpageObject();

			Homepageobject home = login.applogin(Username, Password);
			Thread.sleep(10000);
			home.clickOnProperty();
			Thread.sleep(10000);
			String title = driver.getTitle();
			System.out.println("Title is >>>>>>>>" + title);
			//Assert.assertTrue(title.equals("PropertiesReliant Parking"));
			Verify.verify(title.equals("Properties - Reliant Parking"), "Validation Error", "Renju Test");
			home.UserlogOut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Homepageobject home=new Homepageobject();
			home.UserlogOut();
		}
		
	}
	
	@DataProvider
		public Object[][] Testcase001Test() {
		// To retrieve data from Columns
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("String name of the Method >>>>>>>>>>>"+name);
		return SuiteUtility.GetTestDataUtility(FilePath, name);
	}

}
