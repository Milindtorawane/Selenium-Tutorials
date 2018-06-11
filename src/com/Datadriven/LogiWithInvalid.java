package com.Datadriven;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogiWithInvalid {
	
	
	

	static WebDriver driver;



	public static void LoginWithInvalidCreadianls(String username,String password) throws Exception
	{


		driver= new FirefoxDriver ();
		System.out.println("I am in login method");
		String appUrl = "https://socialnightlife.com/";
		driver.get(appUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);          
		driver.findElement(By.xpath("//form[@id='login-form']/button[@class='btn btn-md btn-primary btn-block']")).click();
		Thread.sleep(5000);



	}


	@Test(description= "Both email and password is blank")
	public static void Method1() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("", "");	
		String MyError1= driver.findElement(By.xpath(".//*[@id='login-form']/label[@for='email']")).getText();
		String MyError2= driver.findElement(By.xpath(".//*[@id='login-form']/label[@for='password']")).getText();
		System.out.println(MyError1);
		System.out.println(MyError2);

		String  ExpectedError1="Please provide a email";
		String  ExpectedError2="Please provide a password";

		Assert.assertEquals(ExpectedError1,MyError1);
		Assert.assertEquals(ExpectedError2,MyError2);

	}


	@Test(description= "Email is blank and password is entered")
	public static void Method2() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("", "123456");	
		String MyError1= driver.findElement(By.xpath(".//*[@id='login-form']/label[@for='email']")).getText();
		System.out.println(MyError1);
		String  ExpectedError1="Please provide a email";
		Assert.assertEquals(ExpectedError1,MyError1);


	}

	@Test(description= "Email is entered and password is blank")
	public static void Method3() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("", "");	

		String MyError2= driver.findElement(By.xpath(".//*[@id='login-form']/label[@for='password']")).getText();	   
		System.out.println(MyError2);    
		String  ExpectedError2="Please provide a password";
		Assert.assertEquals(ExpectedError2,MyError2);

	}


	@Test(description= "Invalid Username and Invalid password")
	public static void Method4() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("milindt@epicomm.net", "Password1");
		String MyError= driver.findElement(By.xpath("//div[@id='error-login']")).getText();
		System.out.println(MyError);
	}


	@Test(description= "valid Username and Invalid password")
	public static void Method5() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("epicomtec@gmail.com","789456");
		String MyError= driver.findElement(By.xpath("//div[@id='error-login']")).getText();
		System.out.println(MyError);

	}


	@Test(description= "Invalid Username and valid password")
	public static void Method6() throws Exception

	{   
		LogiWithInvalid.LoginWithInvalidCreadianls("epicomtecwq@gmail.com","123456");
		String MyError= driver.findElement(By.xpath("//div[@id='error-login']")).getText();
		System.out.println(MyError);

	}



	
	

	@AfterMethod
	public void closeBrowser(){
		driver.close();
		
		
	}


}


