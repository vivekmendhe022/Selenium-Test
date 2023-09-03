package com.class14.jsExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TS1 {

	WebDriver d = null;

	@BeforeClass
	public void BCLaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// d.get("https://www.album.alexflueras.ro/galleries/urban.html");
		// d.get("https://www.naukri.com/registration/createaccount");
		d.get("https://polarbear.co.in/");
	}

	@AfterClass
	public void ACCloseBrowser() {
//		d.quit();
	}
	

	public void JSScrollIntoView(WebDriver d, WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(false)", Element);
	}

	public void m1() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		for (;;) {
			try {
				// driver.findElement(By.linkText("Day of the Dead 2022")).click();
				d.findElement(By.id("a18")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(300,0)");
			}
		}
	}


	public void m2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) d;
		String filePath = "D:\\Vivekanand Mendhe Resume.pdf";

		WebElement resume = d.findElement(By.xpath("//button[text()='Upload Resume']"));
		resume.sendKeys(filePath);

//		resume.click();
//		js.executeScript("arguments[0].scrollIntoView(false)", resume);
		
	}

	@Test
	public void m3() {

		JavascriptExecutor js = (JavascriptExecutor) d;
		
		WebElement img = d.findElement(By.xpath("(//div[@class='sbi_photo_wrap'])[3]"));
		js.executeScript("arguments[0].scrollIntoView(false)", img);

//		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
	}

}
