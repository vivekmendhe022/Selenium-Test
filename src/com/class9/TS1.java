package com.class9;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS1 {
	void m1() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://in.Linkedin.com/");
		driver.findElement(By.id("session_key")).sendKeys("Bhoomika");

		driver.findElement(By.id("session_password")).sendKeys("abc@123");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

		driver.quit();
	}

	void m2() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		driver.get("https://www.shoppersstack.com/products_page/40");

		driver.findElement(By.id("Check Delivery")).sendKeys("411052");

		WebElement checkbutton = driver.findElement(By.id("Check"));
		wait.until(ExpectedConditions.elementToBeClickable(checkbutton));

		checkbutton.click();
	}

	void select() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demoapp.skillrary.com/ ");
		WebElement ListBox = driver.findElement(By.id("cars"));

		// create an object of Select class
		Select option = new Select(ListBox);
		System.out.println(option.isMultiple());

		option.selectByIndex(2);
		option.selectByValue("500");
		option.selectByVisibleText("INR ");
		System.out.println(option.getFirstSelectedOption());
		Thread.sleep(5000);

		driver.quit();

	}

	void select2() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demoapp.skillrary.com/");
		WebElement dropdown = driver.findElement(By.name("addresstype"));
		Select option = new Select(dropdown);

		System.out.println(option.isMultiple());
		option.selectByIndex(4);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		TS1 t = new TS1();
		t.select2();
	}
}
