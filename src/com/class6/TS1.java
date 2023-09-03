package com.class6;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.woodenstreet.com/ ");
		Thread.sleep(10000);
		
		
		d.findElement(By.xpath("//div[contains(@class,'swpmodal-close reqClose')]")).click();
		Thread.sleep(3000);
		
		d.findElement(By.xpath("//div/a/p[@class='category-name']")).click();
		Thread.sleep(3000);
		
		d.findElement(By.xpath("//div/a[contains(text(), 'Maeve')]")).click();
		
//		d.findElement(By.linkText("Log in")).click();
	}
}
