package com.selenium.basic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyJsoup {
	
	static WebDriver driver;
	
	
public static void main(String[] args) throws Exception{

		
		
		driver= new FirefoxDriver();
		driver.get("https://stackoverflow.com/questions/27720839/web-scrapping-with-jsoup-and-selenium");
		// Document document = Jsoup.parse(html);
		 
		  Document doc = Jsoup.connect("http://google.com").get();
		   String title = doc.title();
		   System.out.println("title: " + title);
		
		
		



	}

}
