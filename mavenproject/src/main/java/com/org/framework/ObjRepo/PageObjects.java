package com.org.framework.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.Suite.RegressionSuite.RegressionTestBase;
import com.org.framework.Util.CommonSeleniumUtil;
import com.org.suiteTestSuitBase.SuiteBase;

public class PageObjects extends SuiteBase  {
	SuiteBase suite =new SuiteBase();

public PageObjects() {
		driver=suite.driver;
		PageFactory.initElements(driver, this);
	}
}
