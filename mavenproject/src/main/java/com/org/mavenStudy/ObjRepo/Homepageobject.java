package com.org.mavenStudy.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepageobject {
	
	public Homepageobject(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public Homepageobject() {
		// null handling
	}

	@FindBy(linkText="/property/properties")
	public WebElement lnkProperties;

	public void clickOnProperty(){
		
	lnkProperties.click();
	}
	
}
