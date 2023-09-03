package com.casting;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript 
{
	public static void main(String[] args) 
	{
		Drivers.drivers();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		
		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		
		String parentWindow = d.getWindowHandle();
		Set<String> childWindow = d.getWindowHandles();
		
		childWindow.remove(parentWindow);

		for (String widowId : childWindow) {
			d.switchTo().window(widowId);
			d.close();
		}
		
		
		
	}
}
