package Mock;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TS_03 {

	public static void main(String[] args) {

		// Set the path of chromedriver.exe file
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to vtiger home page
		driver.get("https://www.vtiger.com/home/");

		driver.findElement(By.linkText("Agree")).click();

		// Create an instance of Actions class for mouse hover action
		Actions actions = new Actions(driver);

		// Hover over Resources tab to make the Contact Us link visible
		WebElement resourcesTab = driver.findElement(By.xpath("//a[@title='Resources']"));
		actions.moveToElement(resourcesTab).build().perform();

		// Click on Contact Us link
		WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUsLink.click();

		// Switch to the newly opened tab
		String parentWindow = driver.getWindowHandle();
		for (String childWindow : driver.getWindowHandles()) {
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

		// Get the phone number of Bengaluru office
		WebElement bengaluruPhone = driver
				.findElement(By.xpath("//div[contains(text(), 'Bengaluru')]/following-sibling::div"));
		String phoneNumber = bengaluruPhone.getText();

		// Print the phone number on console
		System.out.println("Phone number of Bengaluru office: " + phoneNumber);

		// Close the newly opened tab
		driver.close();

		// Switch back to the parent tab and close it
		driver.switchTo().window(parentWindow);
		driver.close();

		// Quit the driver instance
		driver.quit();
	}

}
