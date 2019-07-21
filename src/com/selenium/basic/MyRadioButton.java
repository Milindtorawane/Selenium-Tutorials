package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyRadioButton {
	
	
	WebDriver driver ;
	
	
	@Test 
	public void LaunchBrowser ()
	
	{   
		
		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://demos.telerik.com/aspnet-ajax/button/examples/overview/defaultvb.aspx");
		//driver.get("http://dev.socialnightlife.com/");
		driver.manage().window().maximize();
	}
	
	
	//Method to select Radio buttton 
	@Test 
	public void RadioButton() throws Exception

   {
		Thread.sleep(10000);
	WebElement RadioButton=driver.findElement(By.xpath("//label[contains(text(),'Link Button')]"));
			
		if(RadioButton.isSelected())
	{
		 System.out.println("Button is selected already");
    } else
	{
    	RadioButton.click();
		System.out.println("I am clicked on RadioButton");
	}

	}
	
	

	//Method to select check box 
	@Test 
	public void CheckButton() throws Exception

	   {
		Thread.sleep(10000);
		WebElement CheckBoxButton=driver.findElement(By.xpath("//label[contains(text(),'UseSubmitBehavior')]"));
		
		
		if(CheckBoxButton.isSelected())
		{
		 System.out.println("Already selected");
	    } else
		{
			System.out.println("not selected");
			CheckBoxButton.click();
		}

	   }
}
