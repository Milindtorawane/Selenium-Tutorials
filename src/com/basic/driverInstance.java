package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverInstance {
	
	
	static WebDriver driver;
	
	public static void main(String []agrs) throws InterruptedException{
		
		
		
		
		driver= new FirefoxDriver();
		//driver.get("https://stackoverflow.com/questions/27616470/webdriver-how-to-check-if-browser-still-exists-or-still-open");
		driver.get("http://18.218.100.32/xstpl/index.php/customlayout/index/mattresses");
		driver.findElement(By.xpath("//div[@class='col-md-12 matsec2blk1']/div[1]/div/a")).click();
		System.out.println("Clicked on button");
//		Thread.sleep(5000);
//		
//		if(driver.toString().contains("null"))
//		{
//
//		System.out.println("driver instance is not present");
//		}
//		else
//		{
//			System.out.println("driver instance is  present");
//		
//		}
//	}

}
}