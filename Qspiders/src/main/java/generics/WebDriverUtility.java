package generics;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/***
 * 
 * @author Mamatha
 *
 */

public class WebDriverUtility extends BaseClass implements IAutoConstants{
	
	
	/**
	 * This method is used to perfomr darg and drop
	 * @param src
	 * @param Destination
	 */
	public void dragAndDrop(WebElement src, WebElement Destination) {
		Actions action=new Actions(driver);

		action.dragAndDrop(src, Destination).perform();
	}
	/**
	 * This method is used to perform right click operation on the reference of driver control
	 */
	public void rightClick() {
		Actions action=new Actions(driver);

		action.contextClick().perform();
	}
	/**
	 * This method is used to perform right click on the element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions action=new Actions(driver);

		action.contextClick(element).perform();
	}
	/**
	 * This method is used to perform double click operation on the reference of driver control
	 */
	public void doubleClick() {
		Actions action=new Actions(driver);

		action.doubleClick().perform();
	}
	/**
	 * This method is used to perform double click on the element
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		Actions action=new Actions(driver);

		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to perform mousehover operation
	 * @param element
	 */
	public void mouseHoveringOnElement(WebElement element) {
		Actions action=new Actions(driver);

		action.moveToElement(element).perform();
	}
	public Select selectReference(WebElement dropdown) {
		Select select=new Select(dropdown);
		return select;
	}
	/**
	 * This method to handle the dropdown based on the string vlaue
	 * @param dropdown
	 * @param Value
	 */
	public void handlingDropdown(WebElement dropdown,String Value) {
		Select select=new Select(dropdown);
		try {
			select.selectByVisibleText(Value);
		}catch(NoSuchElementException e) {
			select.selectByValue(Value);
		}
	}
	/**
	 * This method is to handle the dropdown by index value
	 * @param dropdown
	 * @param index
	 */
	public void handlingDropdown(WebElement dropdown, int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	/**
	 * This method is to scroll the window based on the x and y coordinates
	 * @param x
	 * @param y
	 */

	public void scrollingAction(int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * This method is to click on the element using javascript executor
	 * @param element
	 */
	public void clickingOnELement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method is used to enter the data into textfield using javascriptexcecutor
	 * @param element
	 * @param data
	 */
	public void enteringDataIntoElement(WebElement element,String data) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
	/**
	 * This method is used to clear the data from textfield using javascriptexcecutor
	 * @param element
	 */
	public void clearingDataFromElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=' '", element);
	}
	/**
	 * This method is to switch the driver control from window to frame
	 * @param index
	 */
	public void switchingToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchingToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchingToFrame(String data) {
		driver.switchTo().frame(data);
	}
	/**
	 * This method to switch back the driver control from frame to main window
	 */
	public void switchingBackToMain() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is to switch the driver control from window to alert
	 * @return
	 */
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	/**
	 * This method is to create webdriverwait instance to achive explicit wait
	 * @param longTime
	 * @return
	 */
	public WebDriverWait explicitWaitingStatement(int longTime) {
		WebDriverWait wait=new WebDriverWait(driver,longTime );
		return wait;
	}
	/**
	 * This method is to switch the driver control from window to window
	 * @param allWindowId
	 * @param targetWindowTitle
	 */
	public void switchToWindow(Set<String> allWindowId, String targetWindowTitle) {
		for(String id:allWindowId) {
			driver.switchTo().window(id);
			if(targetWindowTitle.equalsIgnoreCase(driver.getTitle())) {
				break;
			}
		}
	}
}
