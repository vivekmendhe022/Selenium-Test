package com.class12.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS3 
{
	static void action() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
		WebDriver d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(d, 20);
		
		Actions actions = new Actions(d);
		
		d.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
//		d.findElement(By.xpath("//iframe[@title='Blank']"));
//		d.findElement(By.id("cbb")).click();
		
//		WebElement iframe = d.findElement(By.xpath("//iframe[@class='demo-frame lazyloadeds']"));
//		d.switchTo().frame(iframe);
//		
		d.switchTo().frame(4);
		
		WebElement TE1 = d.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebElement trash = d.findElement(By.xpath("//h4[text()=' Trash']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(TE1));
		actions.moveToElement(TE1).perform();		
		actions.dragAndDrop(TE1, trash);
		Thread.sleep(3000);
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		TS3.action();
	}
}
