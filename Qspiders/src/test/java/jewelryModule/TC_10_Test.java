package jewelryModule;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generics.BaseClass;
import generics.ListenerImplementation;
@Listeners (generics.ListenerImplementation.class)

public class TC_10_Test extends BaseClass{
	@Test
	public void addingTheJewelryToCart() throws InterruptedException {
		home.getJewelryLink().click();
		ListenerImplementation.logger.log(Status.INFO, "Clicked on jewelry link");
		jewelry.getAddtoCartbutton().click();
		ListenerImplementation.logger.log(Status.INFO, "clicked on addtocart button");
		jewelry.getLengthInCmTF().sendKeys("15");
		ListenerImplementation.logger.log(Status.INFO, "Added Length");
		System.out.println("gitgit");
		jewelry.getAddToCartFinalButton().click();
		ListenerImplementation.logger.log(Status.INFO, "clicked on addtocart button");

		home.getShoppingCartLink().click();
		ListenerImplementation.logger.log(Status.INFO, "clicked on shoppingcart link");

		Thread.sleep(2000);
		if(jewelry.getFinalElement().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "The element is displaying");
		}else {
			ListenerImplementation.logger.log(Status.INFO, "The element is not displayed");
		}
	}
}
