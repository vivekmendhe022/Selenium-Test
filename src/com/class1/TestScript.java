package com.class1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("http://polarbear.co.in/");

//		=============================

		String windowHandle = d.getWindowHandle();
		System.out.println(windowHandle); // Output: 674267106C6B82F887473AD021CE36DB
		Thread.sleep(2000);

//		=============================

		d.close();
	}

	public void switchToWindow(WebDriver d, String partialWindowTitle) {
		// capture window ids
		Set<String> windowIds = d.getWindowHandles();

		// navigate to all windows
		for (String windowId : windowIds) {
			// get window title
			String actualWindowTitle = d.switchTo().window(windowId).getTitle();
			// 
			if (actualWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

}
