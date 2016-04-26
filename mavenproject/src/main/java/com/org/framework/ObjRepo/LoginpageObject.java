package com.org.framework.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageObject extends PageObjects{

public LoginpageObject(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@name='UserName']") 	public WebElement username;
	@FindBy(xpath = "//*[@id='Password']")   	public WebElement password;
	@FindBy(id = "btnSubmit")					public WebElement btnlogin;	

		
	
	/**
	 * Login to the Reliant application
	 * @author: renju
	 * @param: Username
	 * @param: Password
	 * 
	 */
	public Homepageobject SuperAdmin(String userName, String Password,WebDriver driver) {
		
		username.sendKeys(userName);
		
		password.sendKeys(Password);

		btnlogin.click();
		
		return new Homepageobject(driver);

	}
	
	public SelectPropertyPageObject Managerlogin(String userName, String Password,WebDriver driver){
		
		username.sendKeys(userName);
		
		password.sendKeys(Password);

		btnlogin.click();
		
		return new SelectPropertyPageObject(driver);
		
	}

}