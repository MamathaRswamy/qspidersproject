package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JewelryPage {
public JewelryPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "(//input[@value='Add to cart'])[1]")
private WebElement addtoCartbutton;

@FindBy(id = "product_attribute_71_10_16")
private WebElement lengthInCmTF;

@FindBy(id="add-to-cart-button-71")
private WebElement AddToCartFinalButton;

public WebElement getAddtoCartbutton() {
	return addtoCartbutton;
}

public WebElement getLengthInCmTF() {
	return lengthInCmTF;
}

public WebElement getAddToCartFinalButton() {
	return AddToCartFinalButton;
}
public WebElement getFinalElement() {
	return FinalElement;
}
@FindBy(xpath = "(//a[text()='Create Your Own Jewelry'])[2]")
private WebElement FinalElement;


}
