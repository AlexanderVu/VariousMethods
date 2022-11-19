package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@name=\"username\"]")
	WebElement login;
	@FindBy(how = How.XPATH, using = "//input[@name=\"password\"]")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
	WebElement signinbutton;

	public void login(String userName, String passWord) {
		login.sendKeys(userName);
		password.sendKeys(passWord);
		signinbutton.click();
	}

}
