package com.class2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript2 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d=new ChromeDriver();
		
		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		
//		48C69F3C775D3647FC76A83C06C53248
//		54741EC3DFCDDB7C4FC15589AB355D11
		
		Set <String> allWindowID = d.getWindowHandles(); 
		for ( String windowId : allWindowID ) 
		{ 
			System.out.println(windowId) ;
		}
		Thread.sleep(6000);
		d.quit();
	}
}
