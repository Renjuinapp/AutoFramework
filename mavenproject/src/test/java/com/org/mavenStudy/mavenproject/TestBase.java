package com.org.mavenStudy.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest    log; 
		
	@BeforeTest
	public static void beforetest(){
		
		reports=new ExtentReports("D:\\AutoFrameWork\\Report\\Result.html");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Reliant\\chromedriver.exe");
		driver=new FirefoxDriver();
		//driver.get()
		driver.navigate().to("http://23.96.61.6/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public static void afterTest(){
		//driver.quit();
		reports.endTest(log);
		reports.flush();
		driver.get("D:\\AutoFrameWork\\Report\\Result.html");
	}
}
