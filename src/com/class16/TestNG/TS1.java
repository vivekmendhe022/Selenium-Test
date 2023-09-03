package com.class16.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TS1 {
	
//	@Test(priority = 1)
//	public void pepsi() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		WebDriver d = new ChromeDriver();
//		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		d.get("http://localhost:8080/INTERCON360/");
//		
//		
//	}
	
	@Test(invocationCount = 2, threadPoolSize = 3)
	static void m2()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
//		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get("http://localhost:8080/INTERCON360/create_promote.jsp");

	}
	
	

}
