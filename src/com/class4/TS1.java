package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TS1 {
	@FindBy(id = "username")
	private WebElement UsernameTextField;

	@FindBy(name = "pwd")
	private WebElement PasswordTextField;

	@FindBy(id = "loginButton")
	private WebElement LoginBtn;
	

	WebDriver driver = null;

	public TS1() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String pwd) {
		UsernameTextField.sendKeys(username);
		PasswordTextField.sendKeys(pwd);
		LoginBtn.click();
	}

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.actitime.com/login.do");
		
		TS1 t=new TS1();
		t.login("admin", "manager");
		
		/*driver.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(3000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);*/
	}
}
