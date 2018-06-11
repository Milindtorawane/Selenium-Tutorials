package com.selenium.AdvancedProgramm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


//Write a program for drag and drop the elements from one folder to another

public class MyDragandDrop {
	
	
	@Test
	public void DragNDrop() throws InterruptedException{
	
	WebDriver driver = new FirefoxDriver();
	driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	
	WebElement From= driver.findElement(By.xpath("//div[@id='treebox1']//span[contains(text(),'Teens')]"));
	Thread.sleep(10000);
	WebElement To= driver.findElement(By.xpath("//div[@id='treebox2']//span[contains(text(),'Bestsellers')]"));
	Thread.sleep(10000);
	
	Actions builder = new Actions(driver);
	Action dragNdrop = builder.clickAndHold(From)
    .moveToElement(To)
    .release(To)
    .build();
	
	dragNdrop.perform();
	
		
	
 
	}

}
