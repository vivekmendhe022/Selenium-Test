package com.casting;

import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers 
{
	static void drivers()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
	}
}
