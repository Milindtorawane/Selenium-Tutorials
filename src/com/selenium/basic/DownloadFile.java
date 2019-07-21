package com.selenium.basic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DownloadFile {


	WebDriver driver;

	@Test
	public void MyFile(){

		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		
		FirefoxProfile profile=new FirefoxProfile();

		// Set preferences for file type 
	//	profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
			    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
		
	

		// Open browser with profile                   
		WebDriver driver=new FirefoxDriver(profile);

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximize window
		driver.manage().window().maximize();

		driver.get("https://aep.terraine.net/AEPSPM/LoginPage.aspx");
		driver.findElement (By.id("UserEmail")).sendKeys("jyoung@terraine.com");
		driver.findElement (By.id("Password")).sendKeys("Macintosh02");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("MainContent_DataEntry")).click();
		Select ele=  new Select (driver.findElement(By.id("MainContent_DropDownListProjects")));
		ele.selectByVisibleText("Clinch River SU");
		Select ele1= new Select (driver.findElement(By.id("MainContent_SystemID_Filter")));
		ele1.selectByVisibleText("12-AS");
		driver.findElement(By.xpath(".//*[@id='MainContent_apply_btn']")).click();
		driver.findElement(By.xpath(".//*[@id='MainContent_btnPrintReport']")).click();

	}



}

