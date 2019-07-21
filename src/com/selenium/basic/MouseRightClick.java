package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseRightClick {

	
	
	
	WebDriver driver;
	
	@Test
	public void RightClickWithMouse () throws InterruptedException{
		
		
		driver = new FirefoxDriver();
		driver.get("http://artoftesting.com/automationTesting/right-click-in-selenium-webdriver-java.html");
		
		Actions act= new Actions(driver);
		WebElement element = driver.findElement(By.xpath(".//*[@id='leftBarDiv']/b[1]/a"));
		Thread.sleep(5000);
		System.out.println("wait compelted");
		//act.contextClick(element).perform();
		act.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Clicked on ");
	}
}
