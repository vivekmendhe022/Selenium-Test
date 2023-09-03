package com.class20.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	public Home_Page(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

}
