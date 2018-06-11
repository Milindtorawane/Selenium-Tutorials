package com.Datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	
	@DataProvider(name="LoginCreaditianls")
	public Object[] MyArray()
	{
		
		Object[][] data= new Object[1][2];
		data[0][0]="Milind";
		
				return data;
		
	}
	
	@Test(dataProvider = "LoginCreaditianls")
	public void TestLogin(String UserName){
		System.out.println(UserName);
	}

}
