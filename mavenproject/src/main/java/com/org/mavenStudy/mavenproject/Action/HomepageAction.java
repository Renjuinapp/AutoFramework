package com.org.mavenStudy.mavenproject.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.org.mavenStudy.ObjRepo.Homepageobject;

public class HomepageAction {

	public static WebDriver driver= new ChromeDriver();
	Homepageobject home =new Homepageobject(driver)	;
	

	
}
