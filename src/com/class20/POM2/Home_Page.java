package com.class20.POM2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	@FindBy(linkText = "Register")
	private WebElement Reg_Page;

	public WebElement getReg_Page() {
		return Reg_Page;
	}
}
