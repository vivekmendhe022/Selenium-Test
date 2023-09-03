package com.class19.CrossBrowser.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Scripting2 {

	String username="admin1";
	String password="manager";
	String expectedLoginPageTitle="actiTIME - Login";
	String expectedHomePageTitle="actiTIME - Enter Time-Track";
	
	WebDriver d;

	@Test
	void login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		d=new ChromeDriver();
		Reporter.log("Empty chrome browser is launched: ", true);
		d.manage().window().maximize();
		Reporter.log("Browser is maximize",true);
		
		// create object of soft assert
		SoftAssert sa = new SoftAssert();
		
		// Navigate to URL
		d.get("https://demo.actitime.com/login.do");
		sa.assertEquals(d.getTitle(), expectedLoginPageTitle, "Error: URL is not entered properly");
		Reporter.log("Login page is display.",true);
		
		// Enter the data to user name text field
		WebElement usernameTextField = d.findElement(By.id("username"));
		usernameTextField.sendKeys(username);
		sa.assertEquals(usernameTextField.getAttribute("value"), username, "Error: username is not entered properly");
		Reporter.log("username is entered", true);
		
		// Entered the data for password text field
		WebElement passwordTextField = d.findElement(By.name("pwd"));
		passwordTextField.sendKeys(password);
		sa.assertEquals(passwordTextField.getAttribute("value"), password, "Error: password is entered not properly");
		Reporter.log("password is entered", true);
		
		// Click on login button
		d.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		sa.assertEquals(d.getTitle(), expectedHomePageTitle, "Error: Home page is not display.");
		Reporter.log("Home page is display", true);
		
		Thread.sleep(3000);
		d.quit();
	}
}
