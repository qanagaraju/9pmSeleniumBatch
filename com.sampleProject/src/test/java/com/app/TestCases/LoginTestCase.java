package com.app.TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import com.app.Utilities.CaptureScreens;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//@Listeners(com.app.Listeners.ListenersBlog.class)
public class LoginTestCase {
	
	public static WebDriver driver;
	public static CaptureScreens capture = new CaptureScreens();
	public static ExtentReports extent = new ExtentReports("./testreports/testreport.html", true);
	public static ExtentTest report = extent.startTest("Login Test");
	
	@BeforeTest
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./AppDrivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		System.out.println("launching browser");
		Reporter.log("Invoke browser");
		report.log(LogStatus.INFO, "Invoke browser");
		
		
	}
   
    @Test
    public void verifymaventest()
    {
    	
    	
    	
    	driver.findElement(By.name("user")).sendKeys("tester");
    	System.out.println("enter username");
    	Reporter.log("verify username");
    	report.log(LogStatus.INFO, "test username");
    	
    	
    	
       
    	driver.findElement(By.name("pass")).sendKeys("admin");
    	System.out.println("Enter password");
    	Reporter.log("verify password");
    	report.log(LogStatus.INFO, "test password");
        
    	WebElement loginbutton = driver.findElement(By.name("btnSubmit"));
    	loginbutton.click();
    	System.out.println("Click login button");
    	Reporter.log("verify login button");
    	report.log(LogStatus.INFO, "click button");
    	
    	if(loginbutton.isEnabled()) {
    		loginbutton.click();
    		report.log(LogStatus.PASS, "step performed");
    	}
    	else
    	{
    		report.log(LogStatus.FAIL,"Step failed");
    	}
    	
    	
    	
    
    	
    	
        
    }
    
   
    
    @AfterTest
    public void quitbrowser() {
    	driver.close();
    	extent.flush();
    	System.out.println("closing driver");
    }
    
    
    
    
    
}
