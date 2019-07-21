package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MyDropDown {
	
	
	
	WebDriver driver;
	
	
	@Test 
	public void LaunchBrowser()
	
	{
		System.setProperty("webdriver.firefox.bin", "D:\\Old_Browser\\firefox.exe");
		WebDriver driver = new  FirefoxDriver();
		driver.get("http://demos.telerik.com/kendo-ui/dropdownlist/index");
		
		
	}
	
	
	
	@Test 
	public void DropDown()
	{
		WebElement DropElement= driver.findElement(By.xpath(""));
		Select obj= new Select(DropElement);
		obj.selectByValue("");
		obj.deselectByIndex(0);
		obj.selectByVisibleText("dropdown option");
		
	}

}
