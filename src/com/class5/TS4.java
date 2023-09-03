package com.class5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS4 
{
	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

		d. get("https://demo.actitime.com/login.do");
		Thread. sleep(4000) ;
		String parentWindow = d.getWindowHandle();		
		d.findElement(By.linkText("actiTIME Inc.")).click();
		Thread.sleep(2000);		
		
		Set<String> allwindow = d.getWindowHandles();
		allwindow.remove(parentWindow);		
		for (String windowId : allwindow) {
			d.switchTo().window(windowId);
		}		
		d.findElement(By.linkText("Try Free")).click();
	}
}
