package com.class8.TakeScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TS1 
{
	void m() throws IOException, InterruptedException
	{
		System. setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage() .window().maximize();		 

		TakesScreenshot ts=(TakesScreenshot) driver;  // down casting

		driver.get("https://www.lays.com/");
		Thread.sleep(2008);

		File destination = new File("./scr/image1.png");
		File webpageScreenshot = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(webpageScreenshot, destination);

		driver.quit();
	}

	
	void m2() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2002);

		WebElement image = driver.findElement(By.xpath("//img[@alt='Footwear']"));
		Thread.sleep(2000) ;

		File destinations=new File("./scr/image2.png");
		File webelementSs = image. getScreenshotAs(OutputType. FILE);
		FileHandler.copy(webelementSs, destinations);		 

		driver .quit();
	}
	
	void m3() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2002);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2002);
		
		WebElement image = driver.findElement(By.xpath("//span[contains(text(),'unsuccessful')]"));
		Thread.sleep(2000) ;

		File destinations=new File("./scr/image3.png");
		File webelementSs = image. getScreenshotAs(OutputType.FILE);
		FileHandler.copy(webelementSs, destinations);		 

		Thread.sleep(2000) ;
		driver .quit();
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		TS1 t=new TS1();
		t.m3();
	}
}
