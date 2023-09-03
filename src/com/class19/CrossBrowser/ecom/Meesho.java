package com.class19.CrossBrowser.ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Meesho {

	WebDriver d;
	
	@Parameters({"browsername","msg"})
	@Test
	void meesho(@Optional("chrome") String bname, String message) throws InterruptedException
	{
		if (bname.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			d = new ChromeDriver();
			d.manage().window().maximize();	
			System.out.println(message);
		}else if(bname.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			d = new FirefoxDriver();
			d.manage().window().maximize();	
			System.out.println(message);
		}
			
		d.get("https://www.meesho.com/");
		Thread.sleep(5000);
		d.quit();
	}
}
