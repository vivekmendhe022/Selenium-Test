package com.class9;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS3 {

	static void m1() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		WebDriverWait wait = new WebDriverWait(d, 15);

		d.get("https://www.geeksforgeeks.org/");

		for (;;) {
			try {
				WebElement modal = d.findElement(By.xpath("//div[@class=\"white-bg center modal-header\"]"));
				File file = new File("./scr/img8.png");
				File screenshotAs = modal.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshotAs, file);

				WebElement modal_api = d.findElement(By.xpath("//div[@class=\"social-signin-div\"]"));
				File file2 = new File("./scr/img9.png");
				File screenshotAs2 = modal_api.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshotAs2, file2);

				WebElement google = d.findElement(By.xpath("//div[@class=\"google-div social-div pull-left\"]"));
				WebElement linkedin = d.findElement(By.xpath("//div[@class=\"linkedin-div social-div pull-left\"]"));

				if (google.getRect().getX() == linkedin.getRect().getX()) {
					System.out.println("Both are align properly.");
				} else {
					System.out.println("Left alignment issue.");
				}
				
				if (google.getRect().getX()+google.getRect().getWidth()==linkedin.getRect().getX()+linkedin.getRect().getWidth()) {
					System.out.println("Both are align properly.");
				}
				else {
					System.out.println("Right alignment Issue.");
				}
				
				if (google.getRect().getY()+google.getRect().getHeight()+3<=linkedin.getRect().getY()) {
					System.out.println("Both are align properly.");					
				} else {
					System.out.println("Overlapping Issue.");
				}

				d.findElement(By.xpath("//span[@class=\"close\"]")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}

		List<WebElement> list = d.findElements(By.xpath("//div[@class=\"header-main__slider\"]"));
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}

		WebElement img = d.findElement(By.xpath("//div[@class=\"header-main__slider\"]"));

		File file1 = new File("./scr/img10.png");
		File screenshotAs1 = img.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs1, file1);

		d.quit();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		TS3.m1();
	}

}
