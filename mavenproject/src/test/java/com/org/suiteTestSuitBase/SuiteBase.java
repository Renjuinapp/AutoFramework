package com.org.suiteTestSuitBase;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.org.framework.DDT.Read_XLS;
import com.org.framework.Util.CommonSeleniumUtil;
import com.org.framework.Util.PropertyUtil;

public class SuiteBase extends CommonSeleniumUtil{	
	private static final Logger logger = LoggerFactory.getLogger(CommonSeleniumUtil.class);
	public static Read_XLS TestSuiteListExcel=null;
	public static Read_XLS RegressionSuiteListExcel =null;
	private boolean BrowseralreadyLoaded =false;
	public static WebDriver ExistingchromeBrowser;
	public static WebDriver ExistingmozillaBrowser;
	public static WebDriver ExistingIEBrowser;
	public  void  init() throws IOException{
		
		//Initializing Test Suite List(TestSuiteList.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestSuiteListExcel = new Read_XLS(System.getProperty("user.dir")+"\\src\\main\\java\\com\\org\\framework\\Excelfiles\\TestSuiteList.xls");
		//Initializing Test Suite One(RegressionSuite.xls) File Path Using Constructor Of Read_XLS Utility Class.
		RegressionSuiteListExcel = new Read_XLS(System.getProperty("user.dir")+"\\src\\main\\java\\com\\org\\framework\\Excelfiles\\RegressionSuite.xls");
		
	}	
	public void loadWebBrowser(String browser) throws MalformedURLException{
		//Validate If any previous webdriver browser Instance Is exist then run new test In that existing webdriver browser Instance.
		
//		if(browser.equalsIgnoreCase("Mozilla") && ExistingmozillaBrowser!=null){
//			driver=ExistingmozillaBrowser;
//			return;
//		}else if(browser.equalsIgnoreCase("Chrome") && ExistingchromeBrowser!=null){
//			driver=ExistingchromeBrowser;
//			return;
//		}else if(browser.equalsIgnoreCase("IE") && ExistingIEBrowser!=null){
//			driver=ExistingIEBrowser;
//			return;
//		}
		if(browser.equalsIgnoreCase("Mozilla")){
			
			driver = new FirefoxDriver();
			logger.info("Firefox Driver Instance loaded successfully.");
			
		}
		if(browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
			
			
			driver = new ChromeDriver();
			logger.info("Chrome Driver Instance loaded successfully.");
			
		}
		if(browser.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//BrowserDrivers//IEDriverServer.exe");

			//To Load Firefox driver Instance. 
			driver = new InternetExplorerDriver();
			logger.info("IE Driver Instance loaded successfully.");
			
		}
		
		
//			driver = new FirefoxDriver();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(PropertyUtil.getConfigProps().getProperty("AppURL"));
			
		
}
	
	public void closeWebBrowser(){
		driver.quit();
	}

		
}
