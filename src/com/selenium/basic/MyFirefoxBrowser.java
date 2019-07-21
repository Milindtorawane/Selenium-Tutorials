package com.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MyFirefoxBrowser {
	
	static String Url=("http://www.seleniumhq.org/download");
	static ExtentReports report;
	static ExtentTest logger;
    static String Reportpath2="D:\\MyReport2.html";
	
	
	
	@Test
	public static void OpenWithFirefox ()
	    
	{   
		report=new ExtentReports(Reportpath2);
		WebDriver driver= new FirefoxDriver ();
	    driver.get(Url);
	    System.out.println("Website has been launched with Firefox driver");
	    logger=report.startTest("Test suite with negative scenarios");

    }
	
	
	@Test
	public static void OpenWithIE()
	{
		System.setProperty("webdriver.ie.driver","F:\\Testing_software\\Browsers\\IEDriverServer.exe" );
		WebDriver driver= new InternetExplorerDriver ();
	    driver.get(Url);
	    System.out.println("Website has been launced with IE browser");
	}
	
	
	@Test 
	public void OpenWithChrome()
	{
		
		System.setProperty("webdriver.chrome.driver","F:\\Testing_software\\Browsers\\chrome.exe");
		WebDriver driver= new ChromeDriver ();
		driver.get(Url);
		System.out.println("Website has been launced with chrome browser");
		
	}
	
	
	
	
}
 