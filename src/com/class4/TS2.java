package com.class4;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TS2 {
	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 * ChromeDriver d = new ChromeDriver(); d.manage().window().maximize();
	 * 
	 * d.get("https://demo.actitime.com/login.do"); Thread.sleep(4000); String
	 * parentWindow = d.getWindowHandle();
	 * 
	 * d.findElement(By.linkText("actiTIME Inc.")).click(); Thread.sleep(2000);
	 * 
	 * Set<String> allwindow = d.getWindowHandles(); allwindow.remove(parentWindow);
	 * 
	 * for (String windowId : allwindow) { d.switchTo().window(windowId); }
	 * 
	 * d.findElement(By.linkText("Try Free")).click(); }
	 */

	@Test
	void m1() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get("https://demo.actitime.com/login.do");

		String parentWindow = d.getWindowHandle();
		d.findElement(By.linkText("actiTIME Inc.")).click();

		Set<String> allWindow = d.getWindowHandles();
		allWindow.remove(parentWindow);

		for (String windowID : allWindow) {
			d.switchTo().window(windowID);
		}
		d.findElement(By.linkText("Try Free")).click();

		d.quit();
	}

}
