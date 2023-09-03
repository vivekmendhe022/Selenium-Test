package com.class13.popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class TS3 {
	static void m1() throws InterruptedException {
		/*
		 * LocalDateTime ldt = LocalDateTime.now().plusMonths(4).plusDays(3); 
		 * String month = ldt.getMonth().toString(); 
		 * month = month.charAt(0) + month.substring(1, month.length()).toLowerCase(); 
		 * int year = ldt.getYear();
		 * int day = ldt.getDayOfMonth(); 
		 * System.out.println(ldt + " " + month + " " +year + " " + " " + day);
		 */

		LocalDateTime time = LocalDateTime.now().plusMonths(3).plusDays(1);
		String month = time.getMonth().toString();
		month= month.charAt(0)+month.substring(1, month.length()).toLowerCase();
		int year = time.getYear();
		int day = time.getDayOfMonth();
		System.out.println( day + " " +month + " "+ year);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.get(" https://www.makemytrip.com/");
		
		for(;;)
		{
			try {
				d.findElement(By.className("ic_circularclose_grey")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}		
		d.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
		Thread.sleep(5000);
		
		for(;;)
		{
			try {
				d.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']")).click();
				break;
			} catch (Exception e) {
				d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}		
		Thread.sleep(5000);
		d.quit();		
	}
	
	static void m2() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.get("https://the-internet.herokuapp.com/basic_auth");
		
		Robot r=new Robot();
		
		Robot robot = new Robot();

		//USERNAME		
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_D);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_M);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_I);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_N);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//PRSSWORD
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_D);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_M);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_I);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_N);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		 
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ENTER);
		
 
		d.quit();
	}
	
	static void m3()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		d.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		d.get("https://www.naukri.com/registration/createAccount?");
		d.findElement(By.id("resumeUpload")).sendKeys("D:/Vivekanand Mendhe Resume.pdf");
		
		d.get("https://highwaydelite.com/#/fastag");
		
		d.findElement(By.name("")).sendKeys(Keys.CONTROL, Keys.F5);
	
	}
	
	static void m5()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("https://highwaydelite.com/#/fastag");
		
		d.findElement(By.id("frontimg")).sendKeys("C:\\Users\\vivek\\Videos\\Photos 4_20_2023 8_04_19 PM.png");
		
	}
	
	static void m4() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		Actions a = new Actions(d);
//		Alert alert = d.switchTo().alert();
		
		d.get("https://the-internet.herokuapp.com/basic_auth");
		
		Robot r = new Robot();				
		
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		d.quit();
	}

	static void takeScreenShotSlack() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.get("https://slack.com/intl/en-in");
		
		WebElement slack = d.findElement(By.xpath("//div[@class='c-billboard__illustration']"));
		
		File file = new File("./scr2/img5.png");
		File screenshotAs = slack.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);
		
		d.quit();		
	}
	
	static void bard() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		d.get("http://localhost:8080/INTERCON360/create_promote.jsp");
		d.get("http://localhost:8080/BARD/");
		
		d.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys("rajpalyadav002");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name='user_email']")).sendKeys("rajpal@gmail.com");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("rajpal123");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@value='male']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@name='check']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);		
	}
	
	static void date()
	{
		LocalDateTime time = LocalDateTime.now().plusMonths(3).plusDays(1);
		String month = time.getMonth().toString();
		month= month.charAt(0)+month.substring(1, month.length()).toLowerCase();
		int year = time.getYear();
		int day = time.getDayOfMonth();
		System.out.println( day + " " +month + " "+ year);
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		date();
	}
}
