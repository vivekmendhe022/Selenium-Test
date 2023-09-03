package com.class20.POM2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS_001 extends Base_Test {

	@DataProvider
	String[][] sendData() throws EncryptedDocumentException, IOException {

		// Create a FileInputStream object with an empty string as the file path
		FileInputStream file = new FileInputStream("D:\\Sftware Testing class\\Selenium\\Notes\\RegisterData.xlsx");

		// Create a Workbook object by loading the file using the FileInputStream
		Workbook workbook = WorkbookFactory.create(file);

		// Get the "Sheet1" from the workbook
		Sheet dataSheet = workbook.getSheet("Sheet1");

		// Get the number of physical rows in the sheet
		int row = dataSheet.getPhysicalNumberOfRows();

		// Get the number of physical cells in the first row of the sheet
		int col = dataSheet.getRow(1).getPhysicalNumberOfCells();

		// Create a 2D String array with dimensions (row - 1) x col to store the data
		// from the sheet
		String[][] data = new String[row - 1][col];

		// Iterate over the rows of the sheet, excluding the first row (header row)
		for (int i = 0; i < row - 1; i++) {

			// Iterate over the cells in each row
			for (int j = 0; j < col; j++) {

				// Retrieve the value of the cell at row (i+1) and column j and convert it to a
				// string
				data[i][j] = dataSheet.getRow(i + 1).getCell(j).toString();
			}
		}

		// Return the populated data array
		return data;

	}

	@Test(dataProvider = "sendData")
	void reg(String[] cred) {
		
		Random random = new Random();
		int r=random.nextInt(1000);

		String expectedRegisterPageTitle = "Demo Web Shop. Register";

		Home_Page hp = new Home_Page(d);
		Reg_Page reg = new Reg_Page(d);

		// Click on registration page
		hp.getReg_Page().click();
		Assert.assertEquals(d.getTitle(), expectedRegisterPageTitle, "Error: Registration page not display");
		Reporter.log("Success: Registration page display");

		// Select the gender
		WebElement gender = null;
		if (cred[0].equalsIgnoreCase("male")) {
			gender = reg.getGenderMale();
			gender.click();
		} else if (cred[0].equalsIgnoreCase("female")) {
			gender = reg.getGenderFemale();
			gender.click();
		}
		Assert.assertEquals(gender.isSelected(), true, "Error: Gender is not selected");
		Reporter.log("Success: Gender not selected");

		// Enter the value into the first name text field
		reg.getFirstName().sendKeys(cred[1]);
		Assert.assertEquals(reg.getFirstName().getAttribute("value"), cred[1], "Error: First Name is not entered");
		Reporter.log("First name is entered");

		// Enter the value into the last name text field
		reg.getLastName().sendKeys(cred[2]);
		Assert.assertEquals(reg.getLastName().getAttribute("value"), cred[2], "Error: Last Name is not entered");
		Reporter.log("Last name is entered");
		
		// Enter the value into the email text field
		reg.getEmail().sendKeys(r+cred[3]);
		Assert.assertEquals(reg.getEmail().getAttribute("value"), r+cred[3], "Error: EMail is not entered");
		Reporter.log("EMail is entered");
		
		// Enter the value into the password text field
		reg.getPassword().sendKeys(cred[4]);
		Assert.assertEquals(reg.getPassword().getAttribute("value"), cred[4], "Error: Password is not entered");
		Reporter.log("Password is entered");
		
		// Enter the value into the confirm password text field
		reg.getCpassword().sendKeys(cred[5]);
		Assert.assertEquals(reg.getCpassword().getAttribute("value"), cred[5], "Error: CPassword is not entered");
		Reporter.log("CPassword is entered");
		

		// Select the registration button
		reg.getRegistrationButton().click();
		Assert.assertEquals(reg.getRegPageElement().isDisplayed(), true, "Error: Register button is not selected.");
		Reporter.log("Success: Register button is selected.");
	}

}
