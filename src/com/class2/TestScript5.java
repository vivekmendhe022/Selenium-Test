package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();

		d.get("https://www.amazon.com");
//		Thread.sleep(5000);

		String currentUrl = d.getCurrentUrl();
		String pageSource = d.getPageSource();
		System.out.println(currentUrl);
		System.out.println(pageSource);
		
		d.get("https://www.google.com");
		
		String currentUrl1 = d.getCurrentUrl();
		String pageSource1 = d.getPageSource();
		System.out.println(currentUrl1);
		System.out.println(pageSource1);
		
		
		System.out.println(currentUrl);
		System.out.println(currentUrl1);
		
	}

}
