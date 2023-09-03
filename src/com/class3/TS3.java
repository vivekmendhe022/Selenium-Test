package com.class3;

import org.openqa.selenium.chrome.ChromeDriver;

class D1
{
	void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
//		d.manage().window().maximize();
		
		d.navigate().to("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		
		System.out.println("Get Size & Position");
		System.out.println(d.manage().window().getSize());
		System.out.println(d.manage().window().getSize().height);
		System.out.println(d.manage().window().getSize().width);
		System.out.println(d.manage().window().getPosition());
		System.out.println(d.manage().window().getPosition().x);
		System.out.println(d.manage().window().getPosition().y);
		Thread.sleep(3000);
		
		
		System.out.println("Get Size & Position");
		d.manage().window().maximize();
		System.out.println(d.manage().window().getSize());
		System.out.println(d.manage().window().getSize().height);
		System.out.println(d.manage().window().getSize().width);
		System.out.println(d.manage().window().getPosition());
		System.out.println(d.manage().window().getPosition().x);
		System.out.println(d.manage().window().getPosition().y);
		Thread.sleep(3000);
		
		d.close();
	}
}

public class TS3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		D1 d1= new D1();
		d1.m1();
	}
}
