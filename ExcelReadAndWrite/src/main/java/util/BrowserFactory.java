package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;
	static ExcelReader exlRead = new ExcelReader("mockdata\\Excel Test data.xlsx");
	static String webSite = exlRead.getCellData("Sheet1", "Website", 2);

	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(webSite);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;

	}

}
