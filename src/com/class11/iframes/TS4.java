package com.class11.iframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TS4 {

	@Test
	static void m1() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d, 20);
		JavascriptExecutor js=(JavascriptExecutor) d;
		Actions a = new Actions(d);

		d.get("https://petdiseasealerts.org/forecast-map#/");
		js.executeScript("window.scrollBy(0,450)");
		
		WebElement frame = d.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		d.switchTo().frame(frame);
		String country="montana";
		
		By cc =By.xpath("//*[name()='svg' and @id='map-svg']/*[name()='g']/*[name()='g' and @id='regions']/*[name()='g' and @id='"+country+"']");
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		a.moveToElement(d.findElement(cc),35,0).click().perform();
	}
}
