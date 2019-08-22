package com.selenium.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyAnnotations {
	
	
	@BeforeSuite
	public void method1()
	{
		System.out.println("1.Executing test case from before suite ");

	}
	
	
	@Test (priority=8)
	public void method2()
	{
		System.out.println("2.Executing test case from single class Test");

	}
	

	@Test(priority=5)
	public void method3()
	{
		System.out.println("3.Executing test case from single class Test");

	}
	

}
