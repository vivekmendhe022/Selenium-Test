package com.class20.POM2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reg_Page {

	public Reg_Page(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	@FindBy(id = "gender-male")
	private WebElement genderMale;
	@FindBy(id = "gender-female")
	private WebElement genderFemale;
	@FindBy(id = "FirstName")
	private WebElement firstName;
	@FindBy(id = "LastName")
	private WebElement lastName;
	@FindBy(id = "Email")
	private WebElement email;
	@FindBy(id = "Password")
	private WebElement password;
	@FindBy(id = "ConfirmPassword")
	private WebElement cpassword;
	
	@FindBy(id = "register-button")
	private WebElement registrationButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement regPageElement;
	
	
	
	public WebElement getRegistrationButton() {
		return registrationButton;
	}
	public WebElement getRegPageElement() {
		return regPageElement;
	}
	public WebElement getGenderMale() {
		return genderMale;
	}
	public WebElement getGenderFemale() {
		return genderFemale;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getCpassword() {
		return cpassword;
	}
	
	

}
