package com.org.framework.Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots{
	
public static String createScreenshot(WebDriver driver,String Testcasename) {
 
   
    // generate screenshot as a file object
	String ScreenShotFolder ="D:\\AutoFrameWork\\Report\\ScreenShot\\";
	String ScreenShotPath=ScreenShotFolder+Testcasename+".png";
	TakesScreenshot ts=(TakesScreenshot)driver;
	File scrFile = ts.getScreenshotAs(OutputType.FILE);
    
	try {
        
		// copy file object to designated location
        FileUtils.copyFile(scrFile, new File(ScreenShotPath));
    } catch (IOException e) {
        System.out.println("Error while generating screenshot:\n" + e.toString());
    }
    return ScreenShotPath;
}
}
