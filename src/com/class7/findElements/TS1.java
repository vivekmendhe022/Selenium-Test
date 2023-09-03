package com.class7.findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 
{
	void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://demowebshop.tricentis.com/");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		d.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		WebElement email = d.findElement(By.id("Email"));
		Thread.sleep(2000);
		System.out.println(email.getAttribute("type"));
		System.out.println(email.getAttribute("autofocus"));
		
		d.quit();
	}
	
	void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://www.facebook.com/");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement email = d.findElement(By.id("email"));
		WebElement pass = d.findElement(By.id("pass"));
		
		if(email.getRect().getX()==pass.getRect().getX())
		{
			System.out.println("Both the element alignment properly");
		}
		else {
			System.out.println("Both the element not align");
		}		
		
	}
	
	void m3() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://www.meesho.com/");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//input[contains(@placeholder,'Try Saree, Kurti or Search by Product Code')]")).sendKeys("kurti", Keys.ENTER);
		Thread.sleep(2000);
		
		String element = d.findElement(By.xpath("//p[contains(text(),'Ethnic Fancy Silk ')]/..//h5")).getText();
		System.out.println(element);
		
		
		d.quit();
	}
	
	void m4() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://demowebshop.tricentis.com/jewelry");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//a[contains(text(),'Create Your Own Jewelry')]/../..//input[@value='Add to cart']")).click();
		Thread.sleep(2000);
//		System.out.println(text);		
		
		Thread.sleep(2000);
		d.quit();
	}
	
	void m5() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://demowebshop.tricentis.com/jewelry");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		List<WebElement> menubar = d.findElements(By.xpath("//ul[@class='top-menu']/li"));
		Thread.sleep(2000);
		
		for (WebElement webElement : menubar) {
			System.out.println(webElement.getText());
		}
		d.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		TS1 t=new TS1();
		t.m5();
	}
}
