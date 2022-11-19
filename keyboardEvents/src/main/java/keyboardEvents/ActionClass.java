package keyboardEvents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionClass {
	
	WebDriver driver;
	
	By userNameField = By.xpath("//input[@id='username']");
	By passWordField = By.xpath("//input[@id='password']");
	
	@BeforeClass
	public WebDriver init() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	@Test
	public void loginTest() {
		
		// By using the Actions class . we can use the method sendKeys ( Keys. to perform actions thats on keyboard )

		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passWordField).sendKeys("abc123");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		
		
		driver.close();
		driver.quit();
		
	}

}
