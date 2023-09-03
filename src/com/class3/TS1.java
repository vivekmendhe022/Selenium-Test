package com.class3;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS1 {
	void cancel() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();

		d.get("file:///D:/Software%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		Thread.sleep(5000);

		Set<String> allWindows = d.getWindowHandles();

		for (String windowId : allWindows) {
			d.switchTo().window(windowId);
			if (d.getTitle().contains("Olive") || d.getTitle().contains("#1") || d.getTitle().contains("Original")) {
				d.close();
			}
		}

//		Thread.sleep(10000);
//		d.quit();
	}

	static void m2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.findElement(By.cssSelector("input")).click();

		Set<String> allWindows = d.getWindowHandles();

		for (String windowID : allWindows) {
			d.switchTo().window(windowID);
			if (d.getTitle().contains("Olive") || d.getTitle().contains("#1") || d.getTitle().contains("Original")) {
				d.close();
			}
		}

//		Thread.sleep(3000);
//		d.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		m2();
	}
}
