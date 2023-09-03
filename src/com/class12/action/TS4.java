package com.class12.action;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TS4 {
	static void m1() throws InterruptedException {

		LocalDateTime ldt = LocalDateTime.now().plusMonths(4).plusDays(3);
		String month = ldt.getMonth().toString();
		month = month.charAt(0) + month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();
		System.out.println(ldt + " " + month + " " + year + " " + " " + day);

//		LocalDateTime localDateTime = LocalDateTime.now().plusMonths(4).plusDays(2);
//		String month = localDateTime.getMonth().toString();
//		month = month.charAt(0) + month.substring(1, month.length()).toLowerCase();
//		int year = localDateTime.getYear();
//		int day = localDateTime.getDayOfMonth();

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		d.get(" https://www.makemytrip.com/");

		d.findElement(By.className("ic_circularclose_grey")).click();
		Thread.sleep(3000);

		d.findElement(By.xpath("//span[text()='Departure']")).click();

		for (;;) {
			try {
				d.findElement(By.xpath("//div[text()='" + month + "" + year + "')]/../..//p[text()='" + day + "']"))
						.click();
				break;
			} catch (Exception e) {
				d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

		Thread.sleep(3000);
		d.quit();

	}
	
	

	public static void main(String[] args) throws InterruptedException {
		m1();
	}
}
