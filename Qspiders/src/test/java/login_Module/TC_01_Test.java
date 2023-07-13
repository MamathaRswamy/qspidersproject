package login_Module;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generics.BaseClass;
import generics.ListenerImplementation;
@Listeners (generics.ListenerImplementation.class)
public class TC_01_Test extends BaseClass {
	@Test
	public void ValidatingLoginFunctionality() {

		home.getLoginLink().click();
		ListenerImplementation.logger.log(Status.INFO, "Clicked on login link");
		login.getEmailTextfield().sendKeys(propertyutility.readingdataFromPropertyFile("username"));
		ListenerImplementation.logger.log(Status.INFO, "Entered on Username to username textfield");

		assertEquals(propertyutility.readingdataFromPropertyFile("username"),login.getEmailTextfield().getAttribute("value"));
		login.getPasswordTextField().sendKeys(propertyutility.readingdataFromPropertyFile("password"));
		ListenerImplementation.logger.log(Status.INFO, "Entered on password to password textfield");


		ListenerImplementation.logger.log(Status.INFO, "clicked on login button");
		login.getLoginButton().click();
	}
}
