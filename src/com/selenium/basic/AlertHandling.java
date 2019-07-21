package com.selenium.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AlertHandling {
	
	WebDriver driver;
	
	@Test
	public void handleAlert(){
		
		driver= new FirefoxDriver();
		driver.get("");
		Alert alert= driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("");
		alert.getText();
	}

}
