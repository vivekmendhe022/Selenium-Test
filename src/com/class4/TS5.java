package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		WebElement serchTextBox = d.findElement(By.id("twotabsearchtextbox"));
		serchTextBox.sendKeys("mobile");
		serchTextBox.sendKeys(Keys.ENTER);
		
		List<WebElement> findElements = d.findElements(By.name(""));
		
		Thread.sleep(2000);		
		d.quit();
	}
}
