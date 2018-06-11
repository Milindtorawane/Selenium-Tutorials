package com.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class OpenBrowser {

	
	static WebDriver driver; 
	
	public static void main (String[]args)
	
	{
		
		
//System.setProperty("webdriver.firefox.driver","");
		  driver = new HtmlUnitDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=klrDWd_fCOSK8QfiiK1g&gws_rd=ssl");
		System.out.println(driver.getTitle());
		driver.close();
		if(driver!=null)
		{
			driver.close();
			System.out.println("driver closed");
		}
		
		
		
	}
}
