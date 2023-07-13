package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebElement getLoginLink() {
		return LoginLink;
	}
	public WebElement getJewelryLink() {
		return jewelryLink;
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Log in")
	private WebElement LoginLink;

	@FindBy(xpath = "(//a[contains(text(),'Jewelry')])[3]")
	private WebElement jewelryLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement ShoppingCartLink;

	public WebElement getShoppingCartLink() {
		return ShoppingCartLink;
	}
}
