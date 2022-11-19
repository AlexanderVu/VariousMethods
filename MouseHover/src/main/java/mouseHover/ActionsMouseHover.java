package mouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsMouseHover {
	
	//Using the actions class and passing the driver as an argument u are able to move to element .build . perform

	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testMouseHover() {

		WebElement ProductElement = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
		WebElement MonitorElement = driver.findElement(By.xpath("//button[text()='Monitors']"));
		WebElement AllMonitorsElement = driver.findElement(By.xpath("//a[text() = 'View All Monitors']"));

		Actions action = new Actions(driver);
		action.moveToElement(ProductElement).build().perform();
		action.moveToElement(MonitorElement).build().perform();
		AllMonitorsElement.click();

		// Assert

	}

}
