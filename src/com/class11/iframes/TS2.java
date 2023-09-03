package com.class11.iframes;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

public class TS2 
{
	static void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
//		d.get("https://www.educba.com/xpath-index/");
		d.navigate().to("https://www.educba.com/xpath-index/");
		
		for (;;){
			try {				
				WebElement popup_card = d.findElement(By.xpath("//div[@id=\"popmake-97847\"]"));
				File img=new File("./scr2/img4.png");
				File screenshotAs = popup_card.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshotAs, img);
				d.findElement(By.xpath("(//button[@class=\"pum-close popmake-close\"])[1]")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}
		
		d.findElement(By.xpath("//button[@class=\"invitation__close\"]")).click();
		
		String pageSource = d.getPageSource();
		System.out.println(pageSource);
				
	}
	
	static void m3() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window() .maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions action=new Actions(driver);

		driver .get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2082);

		 

		WebElement electronics = driver. findElement (By.partialLinkText("ELECTRONICS"));
		action.moveToElement (electronics) .perform();
		Thread.sleep(2082);
	
	}
	
	static void m4() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window() .maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions action=new Actions(driver);

		driver .get("https://demoapp.skillrary.com/product.php?product=selenium-training");
		Thread.sleep(2082);
		
		WebElement add = driver.findElement(By.id("add"));
		
		//to double click
		action.doubleClick(add) .perform();
		Thread.sleep(2008);
		action.doubleClick (add). perform();
		Thread.sleep(2000);	 
		action.doubleClick(add) .perform();
		Thread.sleep(2008);
		action.doubleClick (add). perform();
		Thread.sleep(2000);	 

		driver.quit();
	}
	
	static void m5() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window() .maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions action=new Actions(driver);

		driver .get("https://trello.com/home ");
		Thread.sleep(2082);
	}
	
		
	public static void main(String[] args) throws InterruptedException {
		m1();
	}
}
