package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownSelection {
	
	
	WebDriver driver;
	@Test
	public void selectDropDown(){
		
		Select sel= new Select(driver.findElement(By.id("")));
		sel.selectByIndex(1);
		sel.selectByValue("China");
		sel.selectByVisibleText("Milind");
		//Returns boolean if the multiple values are selected
		sel.isMultiple();
		
		
	}

}
