package com.Datadriven;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.exceluilities.Excelib;

public class MyLogin {


	@Test(dataProvider = "LoginCreaditianls")
	public void Login(String Username,String password,String Third, String F ) throws IOException
	{
		System.out.println("In side login");
		System.out.println(Username);
		System.out.println(password);
		System.out.println(Third);
		System.out.println(F);
		
	}


	@DataProvider(name="LoginCreaditianls")
	public Object[][] myarray() throws Exception 
	{

		Excelib obj= new Excelib();
		obj.SetExcel("F:\\Epicomm.xls");
		int Row=obj.getRowCount();
		//System.out.println(Row);
		int col=obj.geCellCount();
		
		Object[][] data= new Object[Row][col];



		for(int i=0;i<Row;i++)
		{

			for(int j=0;j<col;j++){
				data[i][j]=obj.getData(i,j);
			//	System.out.println(data[i][j]);
			//	data[i][j]=obj.getData(i,j);
			//	System.out.println(data[i][j]);

			}
		}


		return data;


	}


}


