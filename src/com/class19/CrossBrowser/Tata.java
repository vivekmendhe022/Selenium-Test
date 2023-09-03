package com.class19.CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tata {

	WebDriver d=null;
	
	@Parameters("browsername")
	@Test
	void tata(String bname) throws InterruptedException {
		if (bname.equalsIgnoreCase("chrome")) {			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			d = new ChromeDriver();
			d.manage().window().maximize();			
		} else if(bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			d = new FirefoxDriver();
			d.manage().window().maximize();
		} else if (bname.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
			d = new EdgeDriver();
			d.manage().window().maximize();			
		}
		
		d.get("https://www.tata.com/");
		Thread.sleep(5000);
		d.quit();
	}
}
