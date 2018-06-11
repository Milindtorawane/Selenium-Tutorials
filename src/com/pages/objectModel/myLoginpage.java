package com.pages.objectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class myLoginpage {
	
	
	
	

	@FindBy(id="login")
	public
	static WebElement LoginPopUp;
	
	@FindBy(xpath="//input[@id='email']")
	public
	static WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']")
	public
	static WebElement Password;
	
	
	@FindBy(xpath="//form[@id='login-form']/button[@class='btn btn-md btn-primary btn-block']")
	public
	static WebElement Submit;
	
	@FindBy(xpath="")
	public
	static WebElement Click;
	
	

//	@Test 
//	public static void OpenBrowser()
//	{
//		
//		 
//		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
//		driver = new FirefoxDriver();
//	    driver.get("http://dev.socialnightlife.com");
//	    PageFactory.initElements(driver, myLoginpage.class);
//		System.out.println("Website Opened successfully");
//		LoginPopUp.click();
//		
//	
//	 

     }
	

