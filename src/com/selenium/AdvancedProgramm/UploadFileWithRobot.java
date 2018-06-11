package com.selenium.AdvancedProgramm;


//Write a program to upload file using robot class


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;



public class UploadFileWithRobot {
	
	static WebDriver driver;
	
	
	
@Test	
public static void UplaodFile() throws Exception{
	
	
	System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
	
	driver = new FirefoxDriver();
	driver.get("http://www.google.com");
	
	driver.manage().window().maximize();
	
	
	
	
 //   driver.findElement(By.id("inputFile")).click();
	
	System.out.println("Browse the file ");
	
	//String Filepath="D://Milindaccount.txt";
	
	//Created the object of string selection class to copy the file lcoation
	StringSelection sel= new StringSelection("milind Torawane");
	System.out.println(sel);
	
	
	
	//File path is copied in clipboard memory
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
	
	System.out.println(sel);
	
	
	Robot rb= new Robot();
	
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	

	


          }



}

