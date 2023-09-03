package com.rectangle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TS_01 {
	@Test
	public void m() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get("https://www.facebook.com/");

		WebElement email = d.findElement(By.name("email"));
		WebElement pass = d.findElement(By.name("pass"));

		// Left Alignment
		if (email.getRect().getX() == pass.getRect().getX()) {
			System.out.println("Both the X-axis element align properly");
		} else {
			System.out.println("Both the X-axis element not align properly");
		}

		// Right Alignment
		if (email.getRect().getX() + email.getRect().getWidth() == pass.getRect().getX() + pass.getRect().getX()) {
			System.out.println("Both alignments are proper");
		} else {
			System.out.println("Both alignments are not proper");
		}

		// Overlapping issue
		if (email.getRect().getY() + email.getRect().getHeight() + 3 <= pass.getRect().getY()) {
			System.out.println("Not Overlapping Issue");
		} else {
			System.out.println("Overlapping Issue");
		}
		
		System.out.println(pass.getCssValue("._9npi"));
		
		System.out.println(email.getLocation());
		System.out.println(pass.getLocation());

		d.quit();
	}
}
