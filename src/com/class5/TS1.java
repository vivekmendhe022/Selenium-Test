package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver d = new ChromeDriver();
	d.manage().window().maximize();

//	d.get("https://demowebshop.tricentis.com/");
//	d.get("https://www.kalkifashion.com/");
//	d.get("https://www.instagram.com/");
	d.get("https://www.flipkart.com/");
	
//	d.findElement(By.partialLinkText("Jewelry")).click();
//	
//	d.findElement(By.className("product-title")).click();
	
	
//	d.findElement(By.partialLinkText("Books")).click();
//	
//	d.findElement(By.linkText("Computing and Internet")).click();
//	
//	
//	
//	String text = d.findElement(By.xpath("//div[@class='short-description']]")).getText();
//	
//	System.out.println(text);
	
//	d.findElement(By.id("wzrk-cancel")).click();
//	
//	d.findElement(By.linkText("Kurtis")).click();
	
//	d.findElement(By.className("_aa4b _add6 _ac4d")).sendKeys("Elon Musk");
	
//	d.findElement(By.name("username")).sendKeys("Elon Musk");
//	d.findElement(By.name("password")).sendKeys("1234567896");
//	
//	d.findElement(By.linkText("Log in")).click();
	
	d.findElement(By.xpath("//div[@class='_2KpZ6l _2doB4z']")).click();
	
}
}
