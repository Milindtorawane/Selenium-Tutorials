package com.selenium.testscripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.objectModel.myLoginpage;

public class loginTestScript extends myLoginpage {


	static WebDriver driver;


	@Test 
	public static void Login()
	{


		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://dev.socialnightlife.com");
		PageFactory.initElements(driver, myLoginpage.class);
		System.out.println("Website Opened successfully");
		LoginPopUp.click();
		UserName.sendKeys("epicomtec1@gmail.com");
		Password.sendKeys("1234567");
		Submit.click();




	}



}