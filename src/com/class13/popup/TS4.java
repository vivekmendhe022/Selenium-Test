package com.class13.popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TS4 
{
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	WebDriver d = new ChromeDriver(options);
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	Actions a = new Actions(d);
	
	d.get("https://yatra.com");
	
	d.findElement(By.className("btngdpr")).click();
	
	WebElement e1 = d.findElement(By.xpath("//span[text()='Departure Date']/../../.."));
//	a.moveToElement(e1).perform();
	a.moveToElement(e1,196, 323);
	Thread.sleep(3000);
	e1.click();
	Thread.sleep(3000);
	d.quit();
}

}
