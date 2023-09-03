package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS3 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

		d.get("https://www.google.com/gmail/about/");

		d.findElement(By.xpath("//div/a/span[contains(text(), 'Create an account')]")).click();
//		d.findElement(By.xpath(""));

		d.findElement(By.name("firstName")).sendKeys("Disha");
		Thread.sleep(2000);
		d.findElement(By.name("lastName")).sendKeys("Patani");
		Thread.sleep(2000);
		d.findElement(By.name("Username")).sendKeys("dishapatani14335");
		Thread.sleep(2000);
		d.findElement(By.name("Passwd")).sendKeys("P@t@ni123");
		Thread.sleep(2000);
		d.findElement(By.name("ConfirmPasswd")).sendKeys("P@t@ni123");
		Thread.sleep(2000);
		d.findElement(By.id("selectioni1")).click();
		Thread.sleep(2000);
		d.findElement(By.className("VfPpkd-vQzf8d")).click();
		Thread.sleep(2000);
		d.findElement(By.id("phoneNumberId")).sendKeys("7620973663");
		Thread.sleep(2000);
		d.findElement(By.className("VfPpkd-vQzf8d")).click();
		Thread.sleep(2000);
		
		
	}
}
