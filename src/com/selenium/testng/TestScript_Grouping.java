package com.selenium.testng;

import org.testng.annotations.Test;

public class TestScript_Grouping {






	@Test(groups="Regression")
	public void method1()
	{
		System.out.println("This is method 1 from Regression");

	}
	
	
	@Test(groups="Regression")
	public void method2()
	{
		System.out.println("This is method 2 from Regression ");

	}
	

	@Test(groups="smoke")
	public void method3()
	{
		System.out.println("This is method 3 from smoke");

	}
	
	
	
	

}
