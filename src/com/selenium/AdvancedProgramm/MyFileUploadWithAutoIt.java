package com.selenium.AdvancedProgramm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyFileUploadWithAutoIt {
	
	
	
	
	 WebDriver driver;
	 
	 
	 
	 @Test
	 
	 public void launchBrowser () throws Exception{
		 
		 WebDriver driver=new FirefoxDriver();
		 driver.get("http://epicomm.net/web/currentopenings.html");
		 driver.findElement(By.id("resume")).click();
		 Runtime.getRuntime().exec("E:\\MyFile.exe");
		 System.out.println("I am uploaded file,please check");
		 
		 
		 
	 }

}
