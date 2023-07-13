package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.JewelryPage;
import objectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public PropertiesUtility propertyutility=new PropertiesUtility();
	public LoginPage login;
	public HomePage home;
	public JewelryPage jewelry;
	@BeforeClass(alwaysRun = true)
	public void LaunchignBrowser() {
		if(propertyutility.readingdataFromPropertyFile("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod(alwaysRun = true)
	public void navigatingToApplication() {
		login=new LoginPage(driver);
		home=new HomePage(driver);
		jewelry=new JewelryPage(driver);
		driver.get(propertyutility.readingdataFromPropertyFile("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void logginOut() {
		System.out.println("logged out");
	}
	@AfterClass(alwaysRun = true)
	public void teardownTheBrowser() {
		driver.quit();
	}
}
