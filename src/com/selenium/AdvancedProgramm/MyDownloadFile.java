package com.selenium.AdvancedProgramm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

//1) Create a FireFox Profile.
//2) Set Preferences as per requirement.
//3) Open Firefox with FireFox Profile.

public class MyDownloadFile {


	//Create the firefox profile object
	FirefoxProfile profile = new FirefoxProfile();


	@Test
	public void DownlaodFile() throws InterruptedException{

	    //Declared the download path for Browser
		profile.setPreference("browser.download.dir","E://");

		//When value=0, its stores on user's desktop
		//When value=1, its stores on downloads folder
		//When value=2, its stores on specified location 
		profile.setPreference("browser.download.folderList",2);

		//A comma-separated list of MIME types to open directly without asking for confirmation. 
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference( "pdfjs.disabled", true );
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);

		//Pass FProfile parameter In webdriver to use preferences to download file.
		FirefoxDriver driver = new FirefoxDriver(profile);  

		// Open APP to download application
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");

		// Click to download
		driver.findElement(By.xpath("//a[contains(text(),'Download Text File')]")).click();

		//Halting the execution for 5 secs to donwload the file completely
		Thread.sleep(5000);







	}

}
