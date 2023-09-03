package com.class13.popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TS1 {

	static void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions actions = new Actions(d);
		
		d.get("https://www.shoppersstack.com/");
		Thread.sleep(5000);
		
		for(;;)
		{
			try {
				d.findElement(By.linkText("Swagger documentation")).click();
				break;
			} catch (Exception e) {
				actions.sendKeys(Keys.PAGE_DOWN);
//				Thread.sleep(3000);
			}
		}
		
		Alert alert = d.switchTo().alert();
		
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
		
	}
	
	static void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions actions = new Actions(d);
		
		d.get("https://netbanking.hdfcbank.com/netbanking/");
//		Thread.sleep(3000);
		
		d.switchTo().frame("login_page");
		Thread.sleep(3000);
		
		d.findElement(By.linkText("CONTINUE")).click();
//		Thread.sleep(3000);
		
		Alert alert = d.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		d.quit();
	}
	
	static void m3() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.get("https://licindia.in/");
		
		for(;;)
		{
			try {				
				d.findElement(By.linkText("Agents Portal")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				Thread.sleep(3000);				
			}
		}
		
		Alert alert = d.switchTo().alert();
		Thread.sleep(3000);		
		alert.accept();
		
		Thread.sleep(3000);		
		d.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TS1.m1();
	}
}
