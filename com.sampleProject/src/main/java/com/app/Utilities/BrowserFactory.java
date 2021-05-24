package com.app.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	//creates the browser driver specified in the system property "browser"
	
	private static WebDriver driver;
	
	public static WebDriver getBrowser(String browserType) {
		
		switch (browserType) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "BrowserDrivers//chromedriver.exe");
				driver = new ChromeDriver();
				break;
			
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "BrowserDrivers//geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
			case "IE":
				System.setProperty("webdriver.ie,driver", "BrowserDrivers//msedgedriver.exe");
				driver = new InternetExplorerDriver();
				break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
	
	
	
	
	
	
	
	


