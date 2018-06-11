package com.selenium.AdvancedProgramm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyRobotClass {
	public class FileUpload {
		 
		@Test
		public void Fileupload() throws InterruptedException, Exception{
		 
			System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		// Start browser
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		        
		  // Specify the file location with extension
		 StringSelection sel = new StringSelection("C:\\Users\\milindt\\Desktop\\Login.text");
		 
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 	
		 driver.get("http://www.zamzar.com/");
		 Thread.sleep(2000);
		 
		// This will click on Browse button
		 //driver.findElement(By.id("inputFile")).click();
		 
	 System.out.println("Browse button clicked");
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
	//	 Thread.sleep(1000);	
		 driver.findElement(By.id("toEmail")).click();
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
	//	 Thread.sleep(1000);
		           
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		}
		 
		}	
	
}
