package com.class12.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS1 {
	static void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions actions = new Actions(d);

		d.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2082);

/*
		// MOVE TO PARTICULAR ELEMENT
		WebElement e1 = d.findElement(By.partialLinkText("COMPUTERS"));
		actions.moveToElement(e1).perform();
		Thread.sleep(5082);

		
		// CLICK ACTION
		WebElement e2 = d.findElement(By.partialLinkText("JEWELRY"));
		actions.click(e2).perform();
		Thread.sleep(5082);
		
		WebElement product = d.findElement(By.id("products-orderby"));
		Select select = new Select(product);
		select.selectByIndex(3);
		
		WebElement size = d.findElement(By.id("products-pagesize"));
		Select select2 = new Select(size);
		select2.selectByIndex(2);
		
		WebElement view = d.findElement(By.id("products-viewmode"));
		Select select3 = new Select(view);
		select3.selectByIndex(1);
*/	
	
		// To right click on web page
		Actions offset = actions.moveByOffset(1035, 197);
		offset.click().perform();
//		actions.contextClick((WebElement) offset).perform();

		String currentUrl = d.getCurrentUrl();
		System.out.println(currentUrl);
		
		Thread.sleep(5082);
		d.quit();
	}
	
	static void m2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions actions = new Actions(d);

		d.get("https://www.flipkart.com");
		Thread.sleep(2000);
		
		String parentWindow = d.getWindowHandle();
		
		for(;;)
		{
			try {
				d.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}
		
		WebElement printer = d.findElement(By.xpath("//div[text()='Printers']"));
		printer.click();
		
		WebElement link = d.findElement(By.linkText("Canon PIXMA E3370 Multi-function WiFi Color Inkjet Prin..."));
		link.click();
		
		Set<String> allWindow = d.getWindowHandles();
		allWindow.remove(parentWindow);
		
		for (String windowID : allWindow) {
			d.switchTo().window(windowID);
		}
		
		WebElement add = d.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]"));
		add.click();
		
		d.findElement(By.xpath("//a[@class=\"_3SkBxJ\"]")).click();
		
		
		
	}
	
	static void m3() throws InterruptedException
	{
		 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions actions = new Actions(d);

		d.get("https://www.levi.in/sale-1?");
		Thread.sleep(2000);
		

		
		WebElement product = d.findElement (By.xpath("//img[@class='second-image second-image-mob']"));
		actions.moveToElement (product) .perform();
		Thread.sleep(2000) ;
		
		d.findElement (By.xpath("//a[@id='quickviewbutton']")).click();
		Thread. sleep(4000) ;
		
		d.quit();

	}
	
	static void m6() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions actions = new Actions(d);
		
		d.get("https://www.levi.in/sale-1?");
		Thread.sleep(2000);
		
		WebElement element = d.findElement(By.xpath("(//div[@class:'product-image'])[1]"));
		actions.moveToElement(element).perform();
		Thread.sleep(4000);
		d.findElement(By.id("quickvienbutton")).click();
		Thread.sleep(4000);
		
		
	}

	static void m4() throws InterruptedException
	{
			System. setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver .manage().window().maximize();
			driver .manage().timeouts().implicitlyWait(10, TimeUnit. SECONDS) ;
			WebDriverWait wait=new WebDriverWait(driver, 20);
			
			Actions action=new Actions(driver);

			driver.get("https://trello.com/home");
			
			driver. findElement (By.linkText("Log in")).click();
			driver. findElement (By. id("user")). sendKeys("boomikashetty20@gmail.com");
			driver. findElement(By.id("login")).click();

			WebElement login = driver. findElement(By.id("login-submit"));
			//wait until login button is displayed
			wait.until(ExpectedConditions.elementToBeClickable(login));
			driver. findElement(By.id("password")).sendKeys("Testing@123");
			login.click();

			driver. findElement(By.xpath("//div[@title='Train the trainers']")).click();
			
			WebElement java = driver.findElement (By. xpath("//span[text()='java']"));
			WebElement selenium = driver. findElement (By.xpath("//span[text()='selenium']"));
			WebElement manual = driver. findElement (By.xpath("//span[text()='manual']"));
			WebElement cpp = driver. findElement (By.xpath("//span[text()='C++']"));
			
			WebElement TE1 = driver. findElement (By.xpath ("//h2[text()='To Do']/../..//span[text()='Add a card']"));
			WebElement TE2 = driver. findElement (By. xpath("//h2[text()='Doing']/../..//span[text()='Add a card']"));
			WebElement TE3 = driver. findElement (By. xpath("//h2[text()='Done']/../..//span[text()='Add a card']"));			

			action.dragAndDrop(java, TE2).perform();
			action.dragAndDrop(selenium, TE2).perform();
			action.dragAndDrop(manual, TE2).perform();
			action.dragAndDrop(cpp, TE2).perform();			
	}
	
	static void m7() throws InterruptedException {
//			System. setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			System. setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage() .window() .maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit. SECONDS) ;

			Actions action=new Actions(driver);

			driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
			Thread. sleep(2000);
			driver.findElement(By.id("userName")).sendKeys("dishapatani");
			driver. findElement (By. id("password") ).sendKeys("@sfmkfmkn56") ;
			driver.findElement(By.id("chkbox")).click();
			
			WebElement ele = driver. findElement(By.xpath("//div[@class='showPassword shownhide']"));			
			action.clickAndHold(ele).perform();
			Thread. sleep(5000);
			driver.quit ();
			
	}	

	public static void main(String[] args) throws InterruptedException {		
		TS1.m4();
	}

}
