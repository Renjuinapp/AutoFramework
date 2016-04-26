package com.org.framework.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.framework.Util.CommonSeleniumUtil;

public class SelectPropertyPageObject extends PageObjects {
	
	CommonSeleniumUtil Util = new CommonSeleniumUtil();
	
	public SelectPropertyPageObject(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public SelectPropertyPageObject() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "PropertyName")
	public WebElement Propertydropdown;

	@FindBy(id="btnPropertySelected")
	public WebElement GoButton;
	
	
	public void  SwitchToPropety(String propetyName)throws Exception{
		Util.selectOptionFromDropDown(Propertydropdown, propetyName);
		GoButton.click();
	}


	
//Page Object
	
}
