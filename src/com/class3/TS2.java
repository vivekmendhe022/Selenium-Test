package com.class3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

class TS
{
	void driver() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		Thread.sleep(5000);
		
		Set<String> allWindows = d.getWindowHandles();
		
		boolean status=d.getTitle().contains("#1")||d.getTitle().contains("Original")||d.getTitle().contains("Olive");
		
		for (String windowId : allWindows) {
			d.switchTo().window(windowId);
			if (status) 
			{
				d.close();
			}
		}
		
		Thread.sleep(10000);
		d.close();
	}
}



public class TS2 
{
	
	static void cancel(TS t) throws InterruptedException
	{
		t.driver();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TS2.cancel(new TS());
	}
}
