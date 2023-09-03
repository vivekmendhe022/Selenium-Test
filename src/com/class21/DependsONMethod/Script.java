package com.class21.DependsONMethod;

import org.testng.annotations.Test;

public class Script {

	@Test
	void createAccount() {
		System.out.println("Account Create Successfully!");
	}
	@Test(dependsOnMethods = "createAccount")
	void createUpdate() {
		System.out.println("Account Update Successfully!");
	}
	@Test(dependsOnMethods = {"createAccount","createUpdate"})
	void createDelete() {
		System.out.println("Account Delete Successfully!");
	}
}
