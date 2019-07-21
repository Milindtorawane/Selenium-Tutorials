package com.selenium.advanceprogramm;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerTest implements ITestListener{

	@Override
	public void onFinish(ITestContext Result) {
		System.out.println("Test case completed");
		
	}

	@Override
	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		System.out.println("Test case completed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Test case completed");
		
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Test case completed");
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Test case completed");
	}

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Test case completed");
		
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
