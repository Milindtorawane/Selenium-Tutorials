package com.selenium.AdvancedProgramm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


//Write a programm to upload the file on website it will work only output type of file is present in Xpath

public class UploadFile {

	
	WebDriver driver;
	
	@Test
	public void MyUpload() throws InterruptedException
	
	
	{
		WebDriver driver = new FirefoxDriver ();
		driver.get("http://www.texttopdfconverter.com/");
		Thread.sleep(10000);
		driver.findElement(By.id("PdfFile")).sendKeys("D:\\Milindaccount.text");
		System.out.println("File uploaded successfully");
	}
}
