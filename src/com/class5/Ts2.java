package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ts2 
{
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver d = new ChromeDriver();
	d.manage().window().maximize();
	
	d.get("https://demowebshop.tricentis.com/");
	
	d.findElement(By.partialLinkText("Books")).click();
	
	d.findElement(By.linkText("Computing and Internet")).click();
	
	String text = d.findElement(By.xpath("//div[@class=\"short-description\"]")).getText();
	
	System.out.println(text);
}
}
