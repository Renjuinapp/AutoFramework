package com.org.framework.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.Suite.RegressionSuite.RegressionTestBase;
import com.org.suiteTestSuitBase.SuiteBase;

public class PageObjects extends SuiteBase{

	public static WebDriver driver;
	
	public PageObjects() {
		driver = RegressionTestBase.driver;
		PageFactory.initElements(driver, this);
	}
}
