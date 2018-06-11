
//This is programm to fetch data from properties file

package com.selenium.AdvancedProgramm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class MyPropertiesFile {
	
	
	
	
	@Test 
	public void method() throws IOException
	{
		
		Properties obj= new Properties();
		FileInputStream file= new FileInputStream ("C:\\Users\\milindt\\workspace\\SeleniumTutorials\\src\\com\\Utiliy\\Config.properties");
		obj.load(file);
		obj.getProperty("Name");
		String abc=obj.getProperty("URL");
		System.out.println(abc);
	
	}

}
