package com.org.framework.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.suiteTestSuitBase.SuiteBase;

public class CommonSeleniumUtil {
	
	public static WebDriver driver;
	
	public void TestAlert (String alertText) throws InterruptedException { 
		//Generating Alert Using Javascript Executor 
		JavascriptExecutor javascript = (JavascriptExecutor) driver; 
		String script="alert('"+alertText+"');"; 
		javascript.executeScript(script);
		Thread.sleep(1000); 
		driver.switchTo().alert().accept(); 
		}
	/**
	 * 
	 * Select a Value from Dropdown / List
	 * @author renju
	 * @param element
	 * @param value
	 */
	public void selectOptionFromDropDown(WebElement element,String value){
	Select dropdown= new Select(element);
	dropdown.selectByVisibleText(value);
	}
	/**
	 * De selecting All Selected option From the Dropdown/List
	 * @author renju
	 * @param element
	 * 
	 */
	
	public void DeSelectAllOptionFromDropDown(WebElement element){
		try {
			Select dropdown= new Select(element);
			dropdown.deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	/**
	 *Wait for Element is clickable  
	 * @param element
	 */
	
	public void WaitForElementClikable(WebElement element,long Sec ){
		WebDriverWait wait = new WebDriverWait(driver, Sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void WaitForPageLoad() throws InterruptedException
	{
		System.out.println("Entered to the Wait AJAX CALL ");
	    while (true) // Handle timeout somewhere
	    {
	    	JavascriptExecutor javascript = (JavascriptExecutor) driver; 
	        boolean ajaxIsComplete;
	    	ajaxIsComplete=(Boolean) javascript.executeScript("return jQuery.active == 0");
	    	if (ajaxIsComplete){
	    		System.out.println("+++++++++++++++++Ajax Call Completed ++++++++++++++++++");
	    		TestAlert("All datas are loaded");
	            break;
	    	}
	        Thread.sleep(100);
	    }
	}
	
	public void waitForElementVisible(WebElement element,long sec) {
		
		WebDriverWait wait = new WebDriverWait(driver, sec); 
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
}
	


