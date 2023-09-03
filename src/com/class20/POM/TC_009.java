package com.class20.POM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_009 extends BaseTest {
	// Fetch the data from excel sheet

	@DataProvider
	String[][] sendData() throws EncryptedDocumentException, IOException {
//		FileInputStream file = new FileInputStream("./testdata/RegisterData.xlsx");
		FileInputStream file = new FileInputStream("D:\\Sftware Testing class\\Selenium\\Notes\\RegisterData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet dataSheet = workbook.getSheet("Sheet1");

		int physicalNumberOfRows = dataSheet.getPhysicalNumberOfRows();
		int physicalNumberOfCells = dataSheet.getRow(1).getPhysicalNumberOfCells();

		// create array to read row & column
		String[][] data = new String[physicalNumberOfRows - 1][physicalNumberOfCells];
		for (int i = 0; i < physicalNumberOfRows - 1; i++) {
			for (int j = 0; j < physicalNumberOfCells; j++) {
				data[i][j] = dataSheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	@Test(dataProvider = "sendData")
	void register(String[] cred) {
		String expectedRegisterPageTitle = "Demo Web Shop. Register";

		Home_Page hp = new Home_Page(d);
		Register_Page reg = new Register_Page(d);

		hp.getRegisterLink().click();
		Assert.assertEquals(d.getTitle(), expectedRegisterPageTitle, "Error: Register page not display");
		Reporter.log("Register page is displyed.", true);

		// Select the gender
		WebElement gender = null;
		if (cred[0].equalsIgnoreCase("male")) {
			gender = reg.getGenderMale();
			gender.click();
		} else if (cred[0].equalsIgnoreCase("female")) {
			gender = reg.getGenderFemale();
			gender.click();
		}
		Assert.assertEquals(gender.isSelected(), true, "Error: Gender " + cred[0] + " is not selected");
		Reporter.log("Gender " + cred[0] + " is selected", true);

		// Enter the data into first name text field
		reg.getFirstNameTextField().sendKeys(cred[1]);
		Assert.assertEquals(reg.getFirstNameTextField().getAttribute("value"), cred[1],
				"Error: Firstname is not entered properly.");
		Reporter.log("Firstname is entered properly.", true);

		// Enter the data into last name text field
		reg.getLastNameTextField().sendKeys(cred[2]);
		Assert.assertEquals(reg.getLastNameTextField().getAttribute("value"), cred[2],
				"Error: Lastname is not entered properly.");
		Reporter.log("Lastname is entered properly.", true);

		// Enter the data into email text field
		reg.getEmailTextField().sendKeys(cred[3]);
		Assert.assertEquals(reg.getEmailTextField().getAttribute("value"), cred[3],
				"Error: Email is not entered properly.");
		Reporter.log("Email is entered properly.", true);

		// Enter the data into password text field
		reg.getPasswordTextField().sendKeys(cred[4]);
		Assert.assertEquals(reg.getPasswordTextField().getAttribute("value"), cred[4],
				"Error: Password is not entered properly.");
		Reporter.log("Password is entered properly.", true);

		// Enter the data into confirm password text field
		reg.getConfirmPasswordTextField().sendKeys(cred[5]);
		Assert.assertEquals(reg.getConfirmPasswordTextField().getAttribute("value"), cred[5],
				"Error: Confirm Password is not entered properly.");
		Reporter.log("Confirm Password is entered properly.", true);

		// Select the register button
		reg.getRegisterButton().click();
		Assert.assertEquals(reg.getRegPageElement().isDisplayed(), true, "Error: Register button is not selected.");
		Reporter.log("Register is Sccessful.", true);

	}
}
