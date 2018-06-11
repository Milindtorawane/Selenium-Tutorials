package com.testScripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static WebDriver driver;
	
@BeforeTest 
@Parameters ("browser")
public void LaunchBrowser (String browser){
	
	if(browser.equalsIgnoreCase("firefox"))
	{    
		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		driver = new FirefoxDriver();
		
	}else if(browser.equalsIgnoreCase("chrome"))
	{	
		System.setProperty("webdriver.chrome.driver","D://chrome.exe");
		driver =new ChromeDriver();
		
	}else if (browser.equalsIgnoreCase("IE"))
	{
		System.setProperty("webDriver.ie.driver","D://IE.exe");
		driver=new InternetExplorerDriver();
	}
	
	
}

}


