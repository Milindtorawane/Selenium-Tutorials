 package com.selenium.AdvancedProgramm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
 
public class toolQaDownload {
	
	static WebDriver driver;
 
public static void main(String[] args) throws InterruptedException {
    //Create FireFox Profile object
FirefoxProfile profile = new FirefoxProfile();
 
//Set Location to store files after downloading.
profile.setPreference("browser.download.dir", "E:\\");
profile.setPreference("browser.download.folderList", 2);


profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");


profile.setPreference("browser.download.useDownloadDir", true);
//profile.setPreference("browser.helperApps.alwaysAsk.force", false);
profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
profile.setPreference("browser.download.manager.closeWhenDone", true);
profile.setPreference("browser.download.manager.showAlertOnComplete", true);
profile.setPreference("browser.download.manager.useWindow", false);
profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", true);
profile.setPreference("pdfjs.disabled", false);
 

driver = new FirefoxDriver(profile);
driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJ.aspx");

Thread.sleep(3000);
driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber=MJ-33301-TR-0000016-2018");


driver.findElement(By.id("download")).click();


/*

 
//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
    "application/pdf");
 
//profile.setPreference( "browser.download.manager.showWhenStarting", false );
//profile.setPreference( "pdfjs.disabled", true );
 
//Pass FProfile parameter In webdriver to use preferences to download file.
FirefoxDriver driver = new FirefoxDriver(profile);  
driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJ.aspx");
Thread.sleep(5000);
// Open APP to download application
driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber=MJ-33301-TR-0000016-2018");
Thread.sleep(5000);
// Click to download

driver.findElement(By.id("download")).click();
//driver.findElement(By.linkText("Test File to Download")).click();
 
//Halting the execution for 5 secs to donwload the file completely
Thread.sleep(5000);
 
//driver.close();
 * 
 */
 
}
 
}