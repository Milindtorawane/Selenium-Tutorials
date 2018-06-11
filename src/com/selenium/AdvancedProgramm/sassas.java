package com.selenium.AdvancedProgramm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class sassas {

	public static void main(String[]args){
	
	// Create a profile
	FirefoxProfile profile=new FirefoxProfile();
	 
	// Set preferences for file type 
	profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
	 
	// Open browser with profile                  
	WebDriver driver=new FirefoxDriver(profile);
	 
	// Set implicit wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	// Maximize window
	driver.manage().window().maximize();
	 
	// Open APP to download application
	driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber=MJ-33301-TR-0000016-2018");
	 
	// Click on download
	
	driver.findElement(By.id("download")).click();
	//driver.findElement(By.xpath(".//*[@id='program-header']/div[4]/a[1]")).click();
	   
	 }
	
}
