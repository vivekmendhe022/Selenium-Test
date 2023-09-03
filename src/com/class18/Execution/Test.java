package com.class18.Execution;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class Test extends BaseTest {

	@org.testng.annotations.Test
	void display() throws InterruptedException
	{
//		Reporter.log("Test display", true);
		d.findElement(By.name("email")).sendKeys("p@gmail.com");
		d.findElement(By.name("password")).sendKeys("123");
		Thread.sleep(2000);		
	}
	
	/*
	 * @org.testng.annotations.Test void com() { Reporter.log("Test com", true); }
	 */
}
