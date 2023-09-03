package com.class18.Execution;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Configuration {

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("From before suite", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("From after suite", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("From after test", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("From before class", true);
	}
}
