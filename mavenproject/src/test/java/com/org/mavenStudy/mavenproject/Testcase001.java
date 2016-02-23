package com.org.mavenStudy.mavenproject;

import org.testng.annotations.Test;

import com.org.mavenStudy.ObjRepo.Homepageobject;
import com.org.mavenStudy.ObjRepo.LoginpageObject;

@Test
public class Testcase001 extends TestBase {

	public void Login() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Automation\\Reliant\\chromedriver.exe");
		// WebDriver driver= new ChromeDriver();
		// driver.navigate().to("http://23.96.61.6/");

		LoginpageObject login = new LoginpageObject();
		//Homepageobject home = new Homepageobject(driver); 
		
		Homepageobject home = login.applogin("rajee.setty@gmail.com","reliant1");
		Thread.sleep(20000);
		home.clickOnProperty();
		Thread.sleep(20000);
	}
}
