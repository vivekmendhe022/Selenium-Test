package com.class13.popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.util.LocaleDateFormat;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	static void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions actions = new Actions(d);

		d.get("https://www.shoppersstack.com/");
		Thread.sleep(5000);

		for (;;) {
			try {
				d.findElement(By.linkText("Swagger documentation")).click();
				break;
			} catch (Exception e) {
				actions.sendKeys(Keys.PAGE_DOWN);
			}
		}

		Alert alert = d.switchTo().alert();
		alert.accept();
		alert.accept();
		alert.accept();
		alert.accept();

		d.quit();
	}

	static void m2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions actions = new Actions(d);

		d.get("https://netbanking.hdfcbank.com/netbanking/");

		d.switchTo().frame("login_page");

		d.findElement(By.linkText("CONTINUE")).click();

		Alert alert = d.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();

		d.quit();
	}

	static void m4() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.get("https://the-internet.herokuapp.com/basic_auth");

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);

		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_TAB);

		Alert alert = d.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * This code contains date pop up of https://www.makemytrip.com
	 * @throws InterruptedException
	 */
	static void date() throws InterruptedException {
		LocalDateTime ldt = LocalDateTime.now().plusMonths(4).plusDays(2);
		String month = ldt.getMonth().toString();
		month = month.charAt(0) + month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://www.makemytrip.com");

		d.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("document.querySelector('.wewidgeticon').click()");

		d.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();

		for (;;) {
			try {
				d.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']")).click();
				break;
			} catch (Exception e) {
				d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}		
		d.quit();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		date();
	}
}
