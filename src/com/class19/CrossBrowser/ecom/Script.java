package com.class19.CrossBrowser.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Script {

	WebDriver d;

	@Test
	void stateElementException() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		d = new ChromeDriver();
		Reporter.log("Empty chrome browser is launched: ", true);
		d.manage().window().maximize();
		Reporter.log("Browser is maximize", true);

		String url = "https://demowebshop.tricentis.com/";
		d.get(url);

		WebElement login = d.findElement(By.linkText("Log in"));

		ExcpicitWait(d, login);

		d.navigate().refresh();
		login.click();

		d.quit();

		// This test script gives you stateElementException because of d.navigate().refresh() statement.
	}

	public void ExcpicitWait(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
