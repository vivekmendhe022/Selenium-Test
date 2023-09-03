package com.class18.Execution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoShop extends BaseTest {

	@Test
	void toClickOnElectronics() throws InterruptedException
	{
		d.findElement(By.partialLinkText("Electronics")).click();
		Thread.sleep(4000);
	}
}
