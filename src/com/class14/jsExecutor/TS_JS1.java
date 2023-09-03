package com.class14.jsExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TS_JS1 {

	
	void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor) d;

		d.get("https://www.google.com/doodles");
//		driver.get("https://www.album.alexflueras.ro/galleries/urban.html");
		
		
		for(;;) {
			try {
				d.findElement(By.linkText("Celebrating Filipino Adobo")).click();
				break;
			} catch (Exception e) {
//				js.executeScript("window.scrollTo(0,200)");
				js.executeScript("window.scrollBy(0,500)");
			}
		}
		
		d.quit();
		
	}
	
	public static void main(String args[]){
		program4();
	}

	public static void program4(){
		int n=123;
		int res=0,rem;
		for( ;n!=0; n=n/10){
			rem=n%10;
			res=res*10+rem;
		}
		System.out.println(res);
	}
}
