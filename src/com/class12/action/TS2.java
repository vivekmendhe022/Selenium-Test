package com.class12.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS2 
{
	public static void main(String[] args) throws InterruptedException {
		TS2.m1();
	}

	private static void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d, 20);
		
		Actions actions = new Actions(d);
		
		d.get("https://trello.com/home");
		
		d.findElement(By.linkText("Log in")).click();
		d.findElement(By.id("user")).sendKeys("boomikashetty20@gmail.com");
		d.findElement(By.id("login")).click();
		
		WebElement login = d.findElement(By.id("login-submit"));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		d.findElement(By.id("password")).sendKeys("Testing@123");
		login.click();
		
		d.findElement(By.xpath("//div[@title='Train the trainers']")).click();
		
		WebElement java = d.findElement(By.xpath("//span[text()='java']"));
		WebElement selenium = d.findElement(By.xpath("//span[text()='selenium']"));
		WebElement manual = d.findElement(By.xpath("//span[text()='manual']"));
		WebElement cpp = d.findElement(By.xpath("//span[text()='C++']"));
		
		WebElement TE1 = d.findElement(By.xpath("//h2[text()='To Do']/../..//span[text()='Add a card']"));
		WebElement TE2 = d.findElement(By.xpath("//h2[text()='Doing']/../..//span[text()='Add a card']"));
		WebElement TE3 = d.findElement(By.xpath("//h2[text()='Done']/../..//span[text()='Add a card']"));
		
		actions.dragAndDrop(java, TE1).perform();
		Thread.sleep(3000);
		
		actions.dragAndDrop(selenium, TE1).perform();
		Thread.sleep(3000);
		
		actions.dragAndDrop(manual, TE1).perform();
		Thread.sleep(3000);
		
		actions.dragAndDrop(cpp, TE1).perform();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
//		d.quit();
	}
}












