package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//*[text()='Log in']")
	WebElement LoginButton;

	@FindBy(xpath = "//*[text()='Logout']")
	WebElement LogoutButton;

	public void enterEmail(String emailadd) throws InterruptedException {
		Thread.sleep(3000);
		email.clear();
		email.sendKeys(emailadd);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void clickLoginButton() {
		LoginButton.click();
	}

	public void clickonlogout() {
		LogoutButton.click();
	}

}
