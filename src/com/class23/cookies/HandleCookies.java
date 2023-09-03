package com.class23.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleCookies {
	
	@Test
	public void main() {
		System.setProperty("webdriver.chrome.driver", "./116Driver/chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://localhost:8888");
		
		Set<Cookie> cookies = d.manage().getCookies();
		System.out.println(cookies);
//		d.quit();
	}

}
