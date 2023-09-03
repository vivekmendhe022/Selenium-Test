package com.class20.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {

	// Element Repository

	public Register_Page(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	@FindBy(id = "gender-male")
	private WebElement genderMale;
	@FindBy(id = "gender-female")
	private WebElement genderFemale;
	@FindBy(id = "FirstName")
	private WebElement firstNameTextField;
	@FindBy(id = "LastName")
	private WebElement lastNameTextField;
	@FindBy(id = "Email")
	private WebElement emailTextField;
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextField;
	@FindBy(id = "register-button")
	private WebElement registerButton;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement regPageElement;

	public WebElement getRegPageElement() {
		return regPageElement;
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

}
