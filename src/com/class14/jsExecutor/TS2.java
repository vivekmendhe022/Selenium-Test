package com.class14.jsExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class TS2 {
	static void m1() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		WebDriver d = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		TakesScreenshot screenshot= (TakesScreenshot) d; 

		d.get("https://www.google.com/doodles");
		
		JavascriptExecutor js=(JavascriptExecutor) d;
		
		
		for(;;) {
			try {				
				d.findElement(By.xpath("//a[@title='Hungary National Day 2023']")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,200)");
			}
		}
		
		WebElement img = d.findElement(By.id("hplogo-img"));
		
		File file = new File("./scr3/img4.mp4");
		File screenshotAs = img.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);

		d.quit();
	}
	
	static void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor) d;
		
		d.get("https://www.naukri.com/registration/createaccount");
		WebElement element = d.findElement(By.xpath("//button[text()='Upload Resume']"));		
		js.executeScript("arguments[0].scrollintoview(false)", element);

		Thread.sleep(5000);
		d.quit();	
		
	}
	
	static void m3()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		d.get("https://demoapp.skillrary.com/");
		WebElement textField = d. findElement(By.xpath("//input[@class='form-control']"));

		JavascriptExecutor js= (JavascriptExecutor) d;
		js.executeScript("arguments[0].value='Hloooo'", textField);
		js.executeScript("arguments[0].value='hloooo'", textField);

		d.quit();
	}
	
	static void m4()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		d.get("https://www.facebook.com/campaign/landing.php?");
		
		WebElement gender = d. findElement(By.name("custom_gender"));

		JavascriptExecutor js= (JavascriptExecutor) d;
		js.executeScript("arguments[0].value='Male'", gender);

		d.findElement(By.xpath("//label[text()='Custom']")).click();
		
		gender.click();
		
		gender.sendKeys("Transgender");
		 
//		d.quit();
	}
	
	static void m5()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		d.get("https://www.levi.in/sale-1?");
		
		WebElement btn = d. findElement(By.id("quickviewbutton"));

		JavascriptExecutor js= (JavascriptExecutor) d;
		js.executeScript("arguments[0].click()", btn);

		 
		d.quit();
	}
	
	static void m6() throws IOException
	{
		FileInputStream fis=new FileInputStream("./testData/insta.properties");
		Properties prop=new Properties();
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String testurl = (String) prop.get("url");
		String pwd=(String) prop.get("password");

		d. get(testurl);
		d. findElement (By .name("username")).sendKeys((String)prop.get("username"));
		d. findElement (By .name("password")).sendKeys (pwd);

		 
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		m2();
	}
}
