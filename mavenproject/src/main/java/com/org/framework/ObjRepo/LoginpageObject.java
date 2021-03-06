package com.org.framework.ObjRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginpageObject extends PageObjects{

	public LoginpageObject() {
		
	}

	@FindBy(xpath = "//*[@name='UserName']")
	public WebElement username;

	@FindBy(xpath = "//*[@id='Password']")
	public WebElement password;

	@FindBy(id = "btnSubmit")
	public WebElement btnlogin;

	
	
	/**
	 * Login to the Reliant application
	 * @author: renju
	 * @param: Username
	 * @param: Password
	 * 
	 */
	public Homepageobject SuperAdmin(String userName, String Password) {
		
		username.sendKeys(userName);
		
		password.sendKeys(Password);

		btnlogin.click();
		
		return new Homepageobject();

	}
	
	public SelectPropertyPageObject Managerlogin(String userName, String Password){
		
		username.sendKeys(userName);
		
		password.sendKeys(Password);

		btnlogin.click();
		
		return new SelectPropertyPageObject();
		
	}

}