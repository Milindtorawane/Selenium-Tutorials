package com.selenium.advanceprogramm;


import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	
	WebDriver driver ;
	@Test
	public void LaunchBrowser() throws Exception{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(
				new URL("http://192.168.0.50:5555/wd/hub"), capability);
		driver.get("https://google.com");
		Assert.assertEquals("Google",driver.getTitle());
	
	}

}
