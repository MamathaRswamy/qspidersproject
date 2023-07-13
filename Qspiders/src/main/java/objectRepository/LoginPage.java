package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "Email")
	private WebElement EmailTextfield;

	@FindBy(id="Password")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement LoginButton;

	public WebElement getEmailTextfield() {
		return EmailTextfield;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

}
