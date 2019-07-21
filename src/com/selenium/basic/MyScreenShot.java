package com.selenium.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class MyScreenShot {
	
	
	
	WebDriver driver = new FirefoxDriver ();
	
		
	@Test
	public void VerifyTitle() throws IOException, InterruptedException{
		
		try{
			driver.get("https://www.google.com");
		    String ActualTitle=driver.getTitle();
		    System.out.println(ActualTitle);
		    //Asertion to fail the test case and take screen shot
		    Assert.assertEquals(ActualTitle,"Googlkjkjkes");
		
		   }catch(AssertionError e){
			   e.printStackTrace();
			   TakeScreenShot();
			  //If the throw e not written the Test will always pass though assertion is failed
			   throw e;
			   
		}
			
		
	}
	
	
	public void TakeScreenShot() throws IOException, InterruptedException {
		
	   //TakesScreenshot is the interface to capture the web page 
	   File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   //Declare destination path for saving the screenShot
	   File dest= new File ("D://MyScreenShots//ScreenShots"+timestamp()+".png");
	   //Copy the source file to destination
	   FileUtils.copyFile(srcFile,dest);
	   System.out.println("Screen shot taken successfully");
	   
		
	}
	
	public String timestamp()
	{
	    //Method to return system timestamp for screenshotname
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	    
	}


	@AfterSuite 
	public void CloseBrowser(){
		
		driver.close();
		
	}

}
