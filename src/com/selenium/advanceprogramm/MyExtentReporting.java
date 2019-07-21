package com.selenium.advanceprogramm;


import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyExtentReporting {


	static ExtentReports report;
	static ExtentTest logger; 





      
   @Test
	public static void method1()	
	{

		
		report= new ExtentReports("D://ExtentReports.html");
		logger.assignCategory("Functional Test");
		report.addSystemInfo("Author","milind Torawane ");
		System.out.println("Browser launched successfully");
		logger=report.startTest("Test case execution is started");	
		logger.log(LogStatus.INFO,"Browser opened successfully");
		logger.log(LogStatus.INFO,"Entered email ");
		logger.log(LogStatus.INFO,"Entered password ");
		logger.log(LogStatus.INFO,"Click on Submit button");
		System.out.println("Browser Closed successfully");
		report.endTest(logger);
		report.flush();
	}

}



