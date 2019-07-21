package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


//This is program for Drag and drop activity
public class MyDragAndDrop {

	WebDriver driver;
	
	
	
	@Test(priority=1)
	public void LaunchBrowser(){
		
		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
		//driver.get("http://dev.socialnightlife.com/");
		driver.manage().window().maximize();	

     
	}
	
	
	
	@Test (priority=2)
	public void DragAndDrop() throws Exception{
		
		Actions obj= new Actions(driver);
		Thread.sleep(10000);
		WebElement From =driver.findElement(By.id("draggable"));
		WebElement To =driver.findElement(By.id("droptarget"));

		System.out.println("Webelement");
		
		
		
		obj.clickAndHold(From);
		System.out.println("Hold");
		Thread.sleep(5000);
		obj.moveToElement(To);
		obj.build().perform();
		
	}
}
