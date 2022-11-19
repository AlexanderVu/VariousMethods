package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	// By creating an XML file with the HTML style coding.. then adding @parameters to your test case.. u are able to pull data from the xml file to 
	// insert into your test case.

	@Test
	@Parameters({ "userName", "password"})
	public void userShouldBeAbleToLogin(String userName, String password, String dashboardValidText) {

		// Class name // Object Creation /// Inheritance(same package only)
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		BrowserFactory.tearDown();
	}

}
