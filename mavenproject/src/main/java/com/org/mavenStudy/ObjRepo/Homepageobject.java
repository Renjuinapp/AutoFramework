package com.org.mavenStudy.ObjRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepageobject extends PageObjects{

	public Homepageobject(){
		
	}
	
	
	@FindBy(xpath="//a[@href='/property/properties']")
	public WebElement lnkProperties;

	public void clickOnProperty(){
		
	lnkProperties.click();
	}
	
}
