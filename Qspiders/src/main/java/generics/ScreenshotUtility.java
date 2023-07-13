package generics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 * 
 * @author Mamatha
 *
 */
public class ScreenshotUtility extends BaseClass implements IAutoConstants{
	/**
	 * This method is used to take the screenshot whenever the method is
	 * invoked but we are using this method in listner implementation to take the
	 * screenshot of the failure
	 * 
	 * @param screenshotName the method name will be given as the argument for the method
	 * @return this method return the path of screenshot so we can attach the screenshot to the report
	 * @throws IOException
	 */
	public static String takingScreenshot(String screenshotName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File photo = screenshot.getScreenshotAs(OutputType.FILE);

		String ldt = LocalDateTime.now().toString().replace(':', '-');
		String destination = System.getProperty("user.dir")+ERRORSHOTS+screenshotName+" "+ldt+".png";
		File dest=new File(destination);
		FileUtils.copyFile(photo, dest);
		return destination;
	}
}










