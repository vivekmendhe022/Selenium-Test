package com.class18.Execution;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {

	@org.testng.annotations.DataProvider
	String[] sendData()
	{
		String a[]= {"https://pizzaonline.dominos.co.in","https://www.foodpanda.com","https://www.swiggy.com"};
		return a;
	}
	
	@Test(dataProvider = "sendData")
	void launchBrowser(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://demowebshop.tricentis.com/");
		d.manage().window().maximize();
		
		d.get(url);
		Thread.sleep(5000);
		d.quit();
	}
}
