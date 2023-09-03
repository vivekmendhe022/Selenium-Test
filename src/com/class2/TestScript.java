package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();

		d.get("file:///D:/Sftware%20Testing%20class/Selenium/Version%203/MultipleWindow.html");
		d.findElement(By.xpath("//input[@value=\"Open Food Sites\"]")).click();
		
		String parentWindow = d.getWindowHandle();
		System.out.println(parentWindow); // 88E4FFACF159ED4EC542CB005D0C3DA6
		String a="7DF508A8208D01BE719A7265AB98AF01";
		if (a.equals(parentWindow)) {
			System.out.println("same");
		}else {
			System.out.println("not same");
		}

		d.quit();

	}
}
