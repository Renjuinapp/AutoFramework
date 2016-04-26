package com.org.framework.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.framework.Util.CommonSeleniumUtil;
import com.org.suiteTestSuitBase.SuiteBase;

public class Homepageobject extends CommonSeleniumUtil{

	
	
	
public Homepageobject(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[text()='Log Out']")
	public WebElement logout;
	
	
	@FindBy(xpath="//a[@href='/property/properties']")
	public WebElement lnkProperties;

	

	
	public void clickOnProperty(WebDriver driver) throws InterruptedException{
	//WaitForPageLoad();
	waitForElementVisible(lnkProperties, 20,driver);
	lnkProperties.click();
	
	}
	
	

	public void UserlogOut(){
		WaitForElementClikable(logout, 15);
		logout.click();
	}
	
}
