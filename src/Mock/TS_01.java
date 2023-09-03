package Mock;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TS_01 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions settings = new ChromeOptions();
		settings.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.kalkifashion.com/");
		driver.findElement(By.id("search-input")).click();
		List<WebElement> searchSuggestions = driver
				.findElements(By.xpath("//div[@class=\"search-suggestions\"]/div/ul/li/a/span"));
		for (WebElement suggestion : searchSuggestions) {
			System.out.println(suggestion.getText());
		}
		driver.findElement(
				By.xpath("(//div[@class=\"search-suggestions\"]/div/ul/li/a/span)[" + searchSuggestions.size() + "]"))
				.click();

		Thread.sleep(6000);
		driver.quit();
	}
}
