package com.class19.CrossBrowser.ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Myntra {

	WebDriver d;
	@Test
	void myntra() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		d = new FirefoxDriver();
		d.manage().window().maximize();		
		d.get("https://www.myntra.com/");
		Thread.sleep(5000);
		d.quit();
	}
}
