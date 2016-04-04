package com.org.Suite.RegressionSuite;

import java.net.MalformedURLException;

import junit.framework.Assert;

import org.apache.poi.hssf.record.IterationRecord;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	private SoftAssert softassert = new SoftAssert();

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browser) throws MalformedURLException {

		FilePath = RegressionSuiteListExcel;
		SheetName = "TestCasesList";
		TestCaseName = this.getClass().getSimpleName();
		System.out.println("Test case name >>>>>>>>>>>"+TestCaseName);
		if (!SuiteUtility.checkToRunUtility(FilePath, SheetName,
				ToRunColumnNameTestCase, TestCaseName)) {
			// log.log(LogStatus.INFO, "Testcase Skipped");
			throw new SkipException(
					TestCaseName
							+ "'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "
							+ TestCaseName);

		} else {

			SuiteUtility.WriteResultUtility(FilePath, SheetName,
					"Pass/Fail/Skip", TestCaseName, "Executed");
			loadWebBrowser(browser);
		}

	}

	@Test(dataProvider = "Testcase001Test")
	public void Testcase001Test(String Username, String Password) throws Exception{

		try {
			System.out.println("<<<<<<<<<<<<<<<<<<<< Entered to the testing parts ONE  >>>>>>>>>>>");
			LoginpageObject login = new LoginpageObject();
			Homepageobject home = login.SuperAdmin(Username, Password);
			// TestAlert("Successfullt Logged in to the System");
			home.clickOnProperty();
			String title = driver.getTitle();
			System.out.println("Title is >>>>>>>>" + title);
			// Assert.assertTrue(title.equals("PropertiesReliant Parking"));
			// Verify.verify(title.equals("Properties  Reliant Parking"),
			// "Validation Error", "Renju Test");
			softassert.assertEquals(title, "Properties  Reliant Parking");
			softassert.assertAll();
			home.UserlogOut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Homepageobject home = new Homepageobject();
			home.UserlogOut();
		}

	}

	@DataProvider
	public Object[][] Testcase001Test() {
		// To retrieve data from Columns
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("String name of the Method >>>>>>>>>>>" + name);
		return SuiteUtility.GetTestDataUtility(FilePath, name);
	}
	@AfterTest
	public void tearDown(){
		System.out.println("<<<<<<<<<<<<<<<<<<<< Entered to the Tear down parts ONE  >>>>>>>>>>>"+driver.getCurrentUrl());
		closeWebBrowser();
	}
}
