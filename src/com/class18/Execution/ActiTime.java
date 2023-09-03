package com.class18.Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActiTime {
/*
	@DataProvider(parallel = true)
	String[][] credentials(){
		String[][] data= {{"admin","manager"},{"trainee","trainee"},{"Bhoomika","Testing@123"}};
		return data;
	}
	
	@Test(dataProvider = "credentials")
	void login(String[] cred) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://demo.actitime.com/login.do");
		d.findElement(By.id("username")).sendKeys(cred[0]);
		d.findElement(By.name("pwd")).sendKeys(cred[1]);
		d.findElement(By.id("loginButton")).click();
	}
*/
	
	@DataProvider(parallel = true)
	String[][] data(){
		String data[][]= {{"admin", "manager"},{"trainee", "trainee"},{"vivek", "vivek"}};
		return data;
	}
	
	@Test(dataProvider = "data")
	void loginn(String cred[]) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();		
		d.get("https://demo.actitime.com/login.do");
		
		d.findElement(By.id("username")).sendKeys(cred[0]);
		d.findElement(By.name("pwd")).sendKeys(cred[1]);
		d.findElement(By.id("loginButton")).click();
	}
	
}
