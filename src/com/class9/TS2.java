package com.class9;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TS2 {
	static void m1() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		TakesScreenshot ts=(TakesScreenshot) d;
		
		d.get("https://in.Linkedin.com/");
		d.findElement(By.id("session_key")).sendKeys("Bhoomika");
		d.findElement(By.id("session_password")).sendKeys("abc@123");
		
		d.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		
		WebElement image = d.findElement(By.xpath("//div[@class=\"card-layout\"]"));
		WebElement img2 = d.findElement(By.id("username"));
		
		List<WebElement> list = d.findElements(By.xpath("//div[@class=\\\"card-layout\\\"]"));

		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
		
		File file = new File("./scr/img3.png");
		File screenshotAs = image.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, file);
		
		File file2 = new File("./scr/img4.png");
		File screenshotAs2 = img2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs2, file2);

		d.quit();
	}

	public static void main(String[] args) throws IOException {
		TS2.m1();
	}
}
