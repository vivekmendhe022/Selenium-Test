package com.class2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript3 
{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		
		String parentWindow = d.getWindowHandle();
		Set<String> childWindow = d.getWindowHandles();
		
		childWindow.remove(parentWindow);
		
		for (String windowId : childWindow) 
		{
			d.switchTo().window(windowId);
			Thread.sleep(3000);
			d.close();
		}

	}

}
