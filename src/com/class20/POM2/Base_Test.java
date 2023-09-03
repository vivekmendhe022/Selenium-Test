package com.class20.POM2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base_Test {
	static WebDriver d = null;

	@BeforeClass
	static void browserSetup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		d = new FirefoxDriver();
		d.manage().window().maximize();
	}

	@BeforeMethod
	void login() {
		d.get("https://demowebshop.tricentis.com/");
	}

	@AfterMethod
	void logout() {
		d.findElement(By.linkText("Log out")).click();
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		d.quit();
	}
}
