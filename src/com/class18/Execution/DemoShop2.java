package com.class18.Execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoShop2 {	

	@DataProvider(parallel = false)
	String[][] data() {
		String[][] data = {{"female","rajkumar","rao","rao@gmail.com","123456","123456"}, {"female","rajkumar","rao","rao@gmail.com","123456","123456"}};
		return data;
	}
	
	@DataProvider(parallel = true)
	String[][] dataFromExcel() throws EncryptedDocumentException, IOException {
		String path="./testdata/RegisterData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(1).getPhysicalNumberOfCells();
		
		// Create Array to read row & cell
		
		String[][] data=new String[row-1][col];
		for (int i = 0; i < row-1; i++) {
			for (int j = 0; j < col; j++) {
				 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

	@Test(dataProvider = "dataFromExcel")
	void login(String[] cred) throws InterruptedException {
		
		Random random = new Random();
		int r=random.nextInt(1000);
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demowebshop.tricentis.com/");

//		d.findElement(By.id("username")).sendKeys(cred[0]);
//		d.findElement(By.name("pwd")).sendKeys(cred[1]);
//		d.findElement(By.id("loginButton")).click();

		d.findElement(By.linkText("Register")).click();
		
		WebElement gender = null;
		WebElement male = d.findElement(By.id("gender-male"));
		WebElement female = d.findElement(By.id("gender-female"));

		if (cred[0].equalsIgnoreCase("male")) {
			gender = male;
			gender.click();
			System.out.println("Male click");
		} else if (cred[0].equalsIgnoreCase("female")) {
			gender = female;
			gender.click();
			System.out.println("Female click");
		}
		
		d.findElement(By.id("FirstName")).sendKeys(cred[1]);
		d.findElement(By.id("LastName")).sendKeys(cred[2]);
		d.findElement(By.id("Email")).sendKeys(r+cred[3]);
		d.findElement(By.id("Password")).sendKeys(cred[4]);
		d.findElement(By.id("ConfirmPassword")).sendKeys(cred[5]);
		
		d.findElement(By.id("register-button")).click();
		
		// Validate
		String text = d.findElement(By.xpath("//div[@class='page-body']")).getText();
		String res="Your registration completed";
		if (text.contains(res.trim())) {
			System.out.println(res);
			System.out.println("Success");
		}else {
			System.out.println("Fail");
		}
		

		Thread.sleep(3000);
		d.quit();
	}
}
