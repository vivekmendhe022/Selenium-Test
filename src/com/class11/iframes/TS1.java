package com.class11.iframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 {
	
	static void m1()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

//		d.get("https://petdiseasealerts.org/forecast-map#/");
//		d.findElement(By.id("montana")).click();
		
		d.get("https://www.dream11.com/");
//		d.switchTo().frame(0); // By Switch to frame using INT indexing
		
		// By Switch to frame using Web Element
		WebElement frame = d.findElement(By.xpath("//iframe[@title=\"Iframe Example\"]"));
		d.switchTo().frame(frame);
		
		d.findElement(By.id("regEmail")).sendKeys("7620973663");
		d.findElement(By.id("regUser")).click();
		
//		d.switchTo().parentFrame(); // Now switch to main frame.
		d.switchTo().defaultContent(); // Switch to main frame.
		
		d.quit();
	}
	
	static void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		d.get("https://petdiseasealerts.org/forecast-map#/");	
		
//		WebElement frame = d.findElement(By.xpath("//iframe[@id=\"map-instance-41035\"]"));
//		d.switchTo().frame(frame);
		
		d.switchTo().frame(0);
		d.findElement(By.id("montana")).click();
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Sign up")).click();

		//iframe[@id="map-instance-51698"]
		Thread. sleep(5000);
//		d.quit();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		TS1.m2();
	}

}
