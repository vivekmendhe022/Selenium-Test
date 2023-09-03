package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS4 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

		d.get("https://demowebshop.tricentis.com/");		
		
//		d.findElement(By.linkText("Register")).click();
//		Thread.sleep(2000);
		
		d.findElement(By.className("ico-register")).click();
		Thread.sleep(2000);
		
		d.findElement(By.id("gender-male")).click();
		d.findElement(By.id("FirstName")).sendKeys("krishna");
		d.findElement(By.id("LastName")).sendKeys("krishna");
		d.findElement(By.id("Email")).sendKeys("krishna00111@gmail.com");
		d.findElement(By.id("Password")).sendKeys("12345678");
		d.findElement(By.id("ConfirmPassword")).sendKeys("12345678");
		
		d.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		
		d.findElement(By.className("register-continue-button")).click();
		
		d.findElement(By.className("ico-logout")).click();
		Thread.sleep(2000);
		
		d.findElement(By.className("ico-login")).click();
		
		d.findElement(By.id("Email")).sendKeys("krishna00111@gmail.com");
		d.findElement(By.id("Password")).sendKeys("12345678");
		d.findElement(By.id("RememberMe")).click();
		Thread.sleep(2000);
		
		d.findElement(By.className("login-button")).click();
		Thread.sleep(2000);
		
		d.findElement(By.className("ico-logout")).click();
		
//		Thread.sleep(6000);
//		d.quit();
	}

}
