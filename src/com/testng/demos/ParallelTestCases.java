package com.testng.demos;

import org.testng.annotations.Test;

public class ParallelTestCases {
	
	
	
	
	
	@Test
	public void Method1()
	
	{
		System.out.println("This is from method 1>>"+Thread.currentThread().getId());
	}
	
	
	@Test
	public void method2(){
		
		System.out.println("This is from method 2"+Thread.currentThread().getId());
		
	}

}
