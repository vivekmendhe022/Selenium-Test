package com.class13.popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TS2 {

	static void m1() throws InterruptedException {
		// set the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Object of web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// go to the website
		d.get("https://www.w3schools.com/");

		// find element
		WebElement search = d.findElement(By.id("search2"));
		search.sendKeys("popup javascript");
		search.sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		d.quit();
	}

	static void m2() throws InterruptedException {
		// set the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Object of web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		Thread.sleep(3000);

		d.switchTo().frame("iframeResult");

		d.findElement(By.xpath("//button[text()='Try it']")).click();

		Alert alert = d.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		Thread.sleep(5000);
		d.quit();
	}

	static void m3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filenamestryjsref_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button{text()='Try it']")).click();

		Alert pronptPopup = driver.switchTo().alert();
		pronptPopup.sendKeys("john");
		Thread.sleep(3008);
		pronptPopup.accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
		Thread.sleep(4000);
		driver.quit();
	}

	static void m4() throws InterruptedException {

		LocalDateTime ldt = LocalDateTime.now().plusMonths(4).plusDays(3);
		String month = ldt.getMonth().toString();
		month = month.charAt(0) + month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();
		System.out.println(ldt + " " + month + " " + year + " " + " " + day);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.get(" https://www.makemytrip.com/");
		
		for(;;)
		{
			try {
				driver.findElement(By.className("ic_circularclose_grey"));
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}
		
		driver.findElement(By.xpath("//span[contains(@class,'circularclose')]")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"]/../..//p[text()='"+day+"]")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}
	
	static void m5() throws AWTException
	{
		System. setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeOptions settings=new ChromeOptions();
//		settings.addArguments("--disable-notifications");
//		WebDriver driver=new ChromeDriver(settings);
		

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
//		ChromeOptions options2 = new ChromeOptions();
//		options2.addArguments("--disable-notifications");
		
		WebDriver d=new ChromeDriver(options);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://www.yatra.com/");
		
		d.findElement(By.xpath("//button[text()='Ok,I Agree']")).click();
		
		d.findElement(By.className("custom-date-container")).click();
		
//		d.findElement(By.xpath("//p[contains(text(),'25 Apr')]")).click();
		
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		m5();
	}
}
