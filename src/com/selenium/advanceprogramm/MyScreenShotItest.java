package com.selenium.advanceprogramm;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MyScreenShotItest {
	
	
	
	WebDriver driver;
	
	@Test
	public void method(){
		
		
		driver=new FirefoxDriver();
		driver.get("https://google.com");
		
	
		Assert.assertEquals("Mysas",driver.getTitle());
      
	}
	
	
	@AfterMethod
	public void ScreenShot(ITestResult result) throws Exception{
		
		String TestCaseName=result.getName();
		System.out.println(TestCaseName);
		
		if(ITestResult.FAILURE==result.getStatus()){
		
			
		File dest = new File("D:\\"+TestCaseName+".png");
		TakesScreenshot obj= (TakesScreenshot)driver;
	    File srcFile=obj.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(srcFile,dest);
	    
		
		System.out.println("Test Case is failed");
			
		}
	}

}
