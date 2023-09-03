package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

		d.get("https://demowebshop.tricentis.com/");

		d.findElement(By.className("ico-register")).click();
		Thread.sleep(2000);

		d.findElement(By.id("gender-male")).click();
		Thread.sleep(2000);

		d.findElement(By.id("FirstName")).sendKeys("ABCD");
		Thread.sleep(2000);
		d.findElement(By.id("LastName")).sendKeys("EFG");
		Thread.sleep(2000);
		d.findElement(By.id("Email")).sendKeys("gobi123@gmail.com");
		Thread.sleep(2000);
		d.findElement(By.id("Password")).sendKeys("1to1000000");
		Thread.sleep(2000);
		d.findElement(By.id("ConfirmPassword")).sendKeys("1to1000000");
		Thread.sleep(2000);
		d.findElement(By.id("register-button")).click();
//	Thread. sleep(2000) ;

		Thread.sleep(4000);
		d.quit();
	}
}
