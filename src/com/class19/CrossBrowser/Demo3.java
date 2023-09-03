package com.class19.CrossBrowser;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo3 {
	public static void main(String[] args) {

		WebDriver d = null;
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		d = new EdgeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://demowebshop.tricentis.com/");
	}
}
