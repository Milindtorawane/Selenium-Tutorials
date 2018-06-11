package com.basic;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;


public class MyFluientWait {
	

	public static void main (String[]args)throws InterruptedException {

	       

	          WebDriver driver = new FirefoxDriver();
	          driver.manage().window().maximize();
	        //  driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
	          driver.get("https://eapps.courts.state.va.us/gdcourts/captchaVerification.do?landing=landing");

	
	        //  driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
	          
	          driver.findElement(By.xpath("")).click();
	          
	          driver.findElement(By.xpath("")).click();
	          
	          FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	          wait.pollingEvery(1, TimeUnit.SECONDS);
	          wait.withTimeout(10, TimeUnit.SECONDS);
              WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            
	public WebElement apply(WebDriver driver) 
	{
	       WebElement ele = driver.findElement(By.xpath("//p[@id='demo']"));
	                     if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) 
	                      {
	                          System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
	                          return ele;

	                     }

	else {
	        System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));

	           return null;

	       }
               }

	          });

          System.out.println("Final visible status is >>>>> " + element.isDisplayed());

	     }

	}


