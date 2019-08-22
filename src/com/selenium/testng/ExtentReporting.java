package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporting {

	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	String Reportpath="D:\\MyReport1.html";
	
	
	@BeforeMethod
	public void MyBeforeMethod()
	
	{   	
		report=new ExtentReports(Reportpath);
	    logger=report.startTest("Test suite with positive scenarios");
		System.out.println("This is in before method ");
		
	}
	
	@AfterMethod
	public void MyAfterMethod(){
		
		logger.log(LogStatus.INFO, "Now in after method");
		System.out.println("This is in after method ");
		//driver.close();

	}
		
	@AfterSuite
	public void MyAfteSuite(){
		
		logger.log(LogStatus.INFO, "Now in AfterSuite");
		System.out.println("I am in afterSuite ");
		report.flush();
		report.endTest(logger);
		report.close();
	}
	
	
	
	@Test
	public void TestMethod1()
	{
   logger.log(LogStatus.INFO, "Now in Method");
   System.out.println("This is in test method 1");
   Assert.assertTrue(true);
   logger.log(LogStatus.PASS,"Verification is succedd");
  
   
		
	}
	
	
	
}
