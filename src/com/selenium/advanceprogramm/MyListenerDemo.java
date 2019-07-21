package com.selenium.advanceprogramm;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerDemo implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Test case is finished ");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Test case is started");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Test case is failed ");
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		System.out.println("Test case is failed ");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test cases is skipped");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test case is successfull");
		
	}

	
	
	
	
	
	
	
	
}
