package com.class22.SVG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SVG1 {
	
	WebDriver d=null;
	
	public void scrollBy() {
		JavascriptExecutor js=(JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(d, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void mouseHoverAction(WebElement element, int x, int y) {
		Actions actions = new Actions(d);
		actions.moveToElement(element, x, y).perform();;
	}

	@Test
	public void svg() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./116Driver/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://petdiseasealerts.org/forecast-map");
		JavascriptExecutor js = (JavascriptExecutor) d;
		WebDriverWait wait = new WebDriverWait(d, 20);
		Actions actions = new Actions(d);

//		js.executeScript("window.scrollBy(0,450)");
		scrollBy();
		Thread.sleep(4000);

		WebElement frame = d.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));

		d.switchTo().frame(frame);

		String regionName = "montana";
		regionName = regionName.toLowerCase();

		By path1 = By.xpath("//*[name()='svg' and @id='map-svg']/*/*/*[name()='g' and @id='" + regionName + "']");

		By regionToClick = By
				.xpath("//*[name()='svg' and @id='map-svg']/*[name()='g' and @id='features']/*/*[name()='g' and @id='"
						+ regionName + "']");

		wait.until(ExpectedConditions.elementToBeClickable(regionToClick));

		actions.moveToElement(d.findElement(regionToClick), 35, 0).click().perform();
		Thread.sleep(4000);

		takeScreenShot(d, regionName);

		d.quit();
	}

	public void takeScreenShot(WebDriver d, String scrname) throws IOException {
		String path = ".\\ScreenShot\\" + scrname + ".png";
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		Files.copy(src, dst);
//		return dst.getAbsolutePath(); // this is foe extent report
	}

}
