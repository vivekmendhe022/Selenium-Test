package com.class10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 {

	static void m1()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		d.get("https://www.dream11.com/");	
		
		
		d.findElement(By.id("regEmail")).sendKeys("7620973663");
		d.findElement(By.id("regUser")).click();
//		d.findElement(By.linkText("GET APP LINK")).click();
		
		d.quit();
	}
	
	public static void main(String[] args) {
		TS1.m1();
	}
}
