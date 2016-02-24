package com.org.mavenStudy.mavenproject;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.org.mavenStudy.ObjRepo.Homepageobject;
import com.org.mavenStudy.ObjRepo.LoginpageObject;
import com.relevantcodes.extentreports.LogStatus;

@Test
public class Testcase001 extends TestBase {

	public void Login() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Automation\\Reliant\\chromedriver.exe");
		// WebDriver driver= new ChromeDriver();
		// driver.navigate().to("http://23.96.61.6/");
		
		log=reports.startTest("Testcase001");
		
		log.log(LogStatus.INFO, "App is up and Running");
		LoginpageObject login = new LoginpageObject();
			
		Homepageobject home = login.applogin("rajee.setty@gmail.com","reliant1");
		Thread.sleep(20000);
		home.clickOnProperty();
		Thread.sleep(20000);
		String title= driver.getTitle();
		System.out.println("Title is >>>>>>>>"+title);
		Assert.assertTrue(title.equals("Properties - Reliant Parking"));
		log.log(LogStatus.PASS, "Sucessfully verified");
	}
}
