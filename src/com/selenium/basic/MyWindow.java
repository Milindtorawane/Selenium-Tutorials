package com.selenium.basic;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;




public class MyWindow {

	WebDriver driver;
	
	@Test
	
   public void MyWindow (){
		
		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		driver= new FirefoxDriver ();
		driver.get("http://www.webdeveloper.com/forum/showthread.php?72649-Getting-a-link-to-open-two-pages");
		driver.findElement(By.xpath("//a[@class='google']")).click();
		Set<String>WindowList=driver.getWindowHandles();
		int WindowSize=driver.getWindowHandles().size();
		System.out.println(WindowSize);
		System.out.println(WindowList);
			
		
		
		
		 
		
		
		
	 
	  
	  
	}
}
