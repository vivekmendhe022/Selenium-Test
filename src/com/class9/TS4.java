package com.class9;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class TS4 {
	static void m1() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TakesScreenshot ts = (TakesScreenshot) d;

		d.get("https://mail.google.com/mail/u/0/#inbox");

		File file = new File("./scr2/img01.png");
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);

		d.quit();

	}

	static void m2() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		d.get("https://mail.google.com/mail/u/0/#inbox");

		WebElement card = d.findElement(By.xpath("//div[@class=\"rhhJr\"]"));
		File file = new File("./scr2/img2.png");

		WebElement logo = d.findElement(By.id("logo"));
		File file2 = new File("./scr2/img3.png");

		File screenshotAs = card.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);

		File logoscr = logo.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(logoscr, file2);

		d.quit();
	}

	static void m3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://www.educba.com/xpath-index/");

		Thread.sleep(3000);
		for (;;) {
			try {
				d.findElement(By.xpath("//button[@aria-label=\"Close\"]")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}
		d.findElement(By.xpath(""));

	}

	static void m5() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

//		d.get("https://petdiseasealerts.org/forecast-map#/");
//		d.findElement(By.id("montana")).click();

		d.get("https://www.dream11.com/");
//		d.switchTo().frame(0); // By Switch to frame using INT indexing

		// By Switch to frame using Web Element
		WebElement frame = d.findElement(By.xpath("//iframe[@title=\"Iframe Example\"]"));
		d.switchTo().frame(frame);
		d.findElement(By.id("regEmail")).sendKeys("7620973663");
		d.findElement(By.id("regUser")).click();

//		d.switchTo().parentFrame(); // Now switch to main frame.
		d.switchTo().defaultContent(); // Switch to main frame.

		d.quit();

	}

	static void img() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://www.icc-cricket.com/homepage");
		WebElement img = d.findElement(By.xpath("(//a[@class='configurable-promo__overlay-link'])[2]"));

		File file = new File("./scr/virat.png");
		File screenshotAs = img.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);
		d.quit();
	}

	public static void main(String[] args) throws IOException {
		img();

	}
}
