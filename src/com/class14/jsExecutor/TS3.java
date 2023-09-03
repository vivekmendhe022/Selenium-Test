package com.class14.jsExecutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TS3 {
	static void m1() throws InterruptedException {
		// Load the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Load the web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("http://localhost:8080/INTERCON360/create_promote.jsp");

		WebElement promote = d.findElement(By.xpath("(//input[@type='text'])[1]"));
		WebElement revenue = d.findElement(By.xpath("(//input[@type='text'])[2]"));
		WebElement budgeted = d.findElement(By.xpath("(//input[@type='text'])[3]"));
		WebElement actual = d.findElement(By.xpath("(//input[@type='text'])[4]"));
		WebElement responce = d.findElement(By.xpath("(//input[@type='text'])[5]"));
		WebElement description = d.findElement(By.name("description"));
		WebElement type = d.findElement(By.id("type"));
		WebElement status = d.findElement(By.id("status"));
		WebElement startdate = d.findElement(By.xpath("(//input[@type='date'])[1]"));
		WebElement enddate = d.findElement(By.xpath("(//input[@type='date'])[2]"));

		JavascriptExecutor js = (JavascriptExecutor) d;

		js.executeScript("arguments[0].value='HP Laptop'", promote);
		js.executeScript("arguments[0].value='800000'", revenue);
		js.executeScript("arguments[0].value='500000'", budgeted);
		js.executeScript("arguments[0].value='300000'", actual);
		js.executeScript("arguments[0].value='10000'", responce);
		js.executeScript("arguments[0].value='It gives us 10000 response & our sales goes up.'", description);

		// Create Select Object
		Select s1 = new Select(type);
		s1.selectByIndex(7);
		s1.selectByValue("");

		Select s2 = new Select(status);
		s2.selectByIndex(1);

		startdate.clear();
		enddate.clear();

		startdate.sendKeys("04-26-2023");
		enddate.sendKeys("04-26-2023");

		Thread.sleep(5000);
		d.quit();

	}

	static void m2() {
		// Load the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Load the web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://www.facebook.com/campaign/landing.php?");

		WebElement gender = d.findElement(By.name("custom_gender"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].value='Transgender'", gender);

//		d.quit();
	}

	static void m3() throws IOException {
		
		FileInputStream f =new FileInputStream("./testdata/insta.properties");
		Properties p=new Properties();
		p.load(f);
		
		// Load the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Load the web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = (String) p.get("url");
		
		String fname = (String) p.get("firstname");
		String lname = (String) p.get("lastname");
		String email = (String) p.get("reg_email__");
		String pass = (String) p.get("reg_passwd__");
		

		d.get(url);
		
		d.findElement(By.name("firstname")).sendKeys(fname);
		d.findElement(By.name("lastname")).sendKeys(lname);
		d.findElement(By.name("reg_email__")).sendKeys(email);
		d.findElement(By.name("reg_email_confirmation__")).sendKeys((String)p.get("reg_email_confirmation__"));
		d.findElement(By.name("reg_passwd__")).sendKeys(pass);
		
		d.quit();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		m1();
	}
}
