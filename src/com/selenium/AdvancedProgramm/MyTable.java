package com.selenium.AdvancedProgramm;

//Write a programm to display value from static table 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class MyTable {

	WebDriver driver;

	
	@Test
	public void MyStaticTable(){

		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-table/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);


		int RowCount=driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
		int Tcol=3;


		for(int i=1;i<=RowCount;i++)
		{
			String Abc=driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+i+"]/td["+Tcol+"]")).getText();
			System.out.println(Abc);

		}

	}







}
