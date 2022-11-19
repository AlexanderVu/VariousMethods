package alertPopups;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	
	// By using the .switchTo.alert u are able to get the text or click the executables.
	
	WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testAlertPopup() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(3000);
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
		
		
		}

}
