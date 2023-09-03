package com.class18.Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider(parallel = false)
	String[][] data() {
		String[][] data= {{"admin","manager"},{"trainee","trainee"},{"",""}};
		return data;
	}
	
	
	@Test(dataProvider = "data")
	void login(String[] cred) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();		
		d.get("https://demo.actitime.com/login.do");
		
		d.findElement(By.id("username")).sendKeys(cred[0]);
		d.findElement(By.name("pwd")).sendKeys(cred[1]);
		d.findElement(By.id("loginButton")).click();
		
		Thread.sleep(3000);
		d.quit();
	}
}
