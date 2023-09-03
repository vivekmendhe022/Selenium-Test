package com.class19.CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Demo1 {
	
	WebDriver d=null;
	
	@Parameters("bname")
	@Test
	void actitime(String bname) throws InterruptedException {
		if (bname.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			d=new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			d=new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if (bname.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
			d=new EdgeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else {
			System.out.println("No browser found.");
		}
		
		d.get("https://www.actitime.com/");
		Thread.sleep(2000);
		d.quit();
		
	}
	
	

}
