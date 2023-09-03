package com.class2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript4 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver d=new ChromeDriver();
	
	d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
	d.manage().window().maximize();
	d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
	Thread.sleep(5000);
	
	Set<String> allWindow = d.getWindowHandles();
		
	for (String o: allWindow) {
		d.switchTo().window(o);
		if (d.getTitle().contains("Olive")) 
		{
			d.close();
		}
	}
}
}
