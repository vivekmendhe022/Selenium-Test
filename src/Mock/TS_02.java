package Mock;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS_02 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.actitime.com/login.do");

		// Implicitly wait for page to load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to the application
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("pwd"));
		WebElement loginBtn = driver.findElement(By.id("loginButton"));

		username.sendKeys("admin");
		password.sendKeys("manager");
		loginBtn.click();

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Click on About your actiTIME present under Help dropdown
		WebElement helpMenu = driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]"));
		wait.until(ExpectedConditions.elementToBeClickable(helpMenu));
		helpMenu.click();

		WebElement aboutActiTime = driver.findElement(By.linkText("About your actiTIME"));
		aboutActiTime.click();

		// Switch to new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		// Click on Read Service Agreement link on the popup
		WebElement serviceAgreementLink = driver.findElement(By.linkText("Read Service Agreement"));
		serviceAgreementLink.click();

		// Capture all the headings and print on console
		ArrayList<WebElement> headings = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//div[@class='header__inner']"));
		for (WebElement heading : headings) {
			System.out.println(heading.getText());
		}

		// Close the new tab
		driver.close();

		// Switch to parent tab
		driver.switchTo().window(tabs.get(0));

		// Close the parent tab
		driver.close();

	}

}
