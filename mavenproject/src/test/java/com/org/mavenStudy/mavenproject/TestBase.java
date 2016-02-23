package com.org.mavenStudy.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	
		
	@BeforeTest
	public static void beforetest(){
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Reliant\\chromedriver.exe");
		driver=new FirefoxDriver();
		//driver.get()
		driver.navigate().to("http://23.96.61.6/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public static void afterTest(){
		driver.quit();
	}
}
