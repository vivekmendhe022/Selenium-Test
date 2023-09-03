package com.class2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript6 {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

//		d.get("https://www.amazon.com");
		
//		d.navigate().to("https://www.amazon.com");
		d.navigate().to(new URL("https://www.amazon.com"));
		
		d.navigate().back();
		Thread.sleep(2000);
		
		d.navigate().forward();
		Thread.sleep(2000);
		
		d.navigate().refresh();
		
		d.navigate().to("");
		
		d.quit();
	}

}
