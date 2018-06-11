package com.selenium.AdvancedProgramm;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class TestDownload {






	@Test
	public void testFirefoxDownloadPopup() throws InterruptedException {
		/* Create a new FireFox Profile instance. */
		FirefoxProfile ffProfile = new FirefoxProfile();

		/* Set file save to directory. */
		ffProfile.setPreference("browser.download.dir", "E:\\");
		ffProfile.setPreference("browser.download.folderList", 2);



		ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); 

		ffProfile.setPreference( "browser.download.manager.showWhenStarting", false );
		ffProfile.setPreference( "pdfjs.disabled", true );

		ffProfile.setPreference("plugin.scan.Acrobat", "99.0");
		ffProfile.setPreference("plugin.scan.plid.all", false);


		/* Create Firefox browser based on the profile just created. */
		FirefoxDriver ffDriver = new FirefoxDriver(ffProfile);  



		ffDriver.get("https://ujsportal.pacourts.us/DocketSheets/MDJ.aspx");
		Thread.sleep(500);
		
		int num=16;
		for(int i=1;i<2;i++){

		/* For tomcat 9.0.zip. */
		//ffDriver.get("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber=MJ-33301-TR-0000016-2018");
		ffDriver.get("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber=MJ-33301-TR-00000"+num+"-2018");

		//ffDriver.get("https://docs.oracle.com/javaee/7/JEETT.pdf");

		/* Wait 10 seconds for the process complete. */
		Thread.sleep(5000);
		
		num++;

		//ffDriver.findElement(By.id("download")).click();

		System.out.println("Task complete, please go to save folder to see it.");
	}

}
}