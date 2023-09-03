package com.class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS2 {
	
	void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.linkedin.com/login");
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Thread.sleep(2000);
	}
	
	void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://demo.vtiger.com/vtigercrm/");
		Thread.sleep(2000);
		
		WebElement username = d.findElement(By.id("username"));
		username.clear();
		username.sendKeys("Qspider");
		Thread.sleep(2000);
		
		WebElement password = d.findElement(By.id("password"));
		password.clear();
		password.sendKeys("123456");
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Thread.sleep(2000);
		
		String text = d.findElement(By.id("validationMessage")).getText();
		System.out.println(text);
		
		
		d.quit();
	}
	
	void m3()
	{
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		TS2 t=new TS2();
		t.m2();
	}

}
