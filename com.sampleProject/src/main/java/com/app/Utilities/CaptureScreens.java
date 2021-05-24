package com.app.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;


public class CaptureScreens {
	
private static WebDriver mDriver;
	
	public static WebDriver getCurrentDriver(String browserType) {
		if (mDriver == null) {
			try {
				mDriver = BrowserFactory.getBrowser(browserType);
			} catch(UnreachableBrowserException e) {
				e.printStackTrace();
			}
		}
		return mDriver;
	}
	
	public static WebDriver getCurrentDriver() {
		return getCurrentDriver(PropertyLoader.getBrowserType());
	}
	
	
	
	public static void takeScreenShot(WebDriver driver, String string) {
		//1. take screenshot and store it as a file format
		try {
			String newFileNamePtath;
			File directory = new File(".");
			//create time stamp format 
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ssaa");
			//current date
			Date date = new Date();
			
			//appending file format and date format to the screen shot
			newFileNamePtath = directory.getCanonicalPath() + "\\screenshots\\" + dateFormat.format(date) + "_" + ".jpg";
			File  file = new File(newFileNamePtath);
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(srcFile, new File(newFileNamePtath));
			
				//FileUtils.copyFile(srcFile, new File("C:\\Uma-Artifacts\\Live-Project\\crm-atf\\screenshots\\" +testMethodName+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
		
		
		
	}


