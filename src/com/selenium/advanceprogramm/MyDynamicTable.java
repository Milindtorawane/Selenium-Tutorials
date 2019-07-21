package com.selenium.advanceprogramm;




import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyDynamicTable {
	
	
	

	@Test
	public void MyStaticTable(){

		System.setProperty("webdriver.firefox.bin","D:\\Old_Browser\\firefox.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("http://demo.guru99.com/selenium/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);
		
		
	
		//List<WebElement>abc=MyTable.findElements(By.tagName("td"));

}
}