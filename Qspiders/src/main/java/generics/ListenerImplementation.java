package generics;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/***
 * 
 * @author Mamatha
 *
 */
public class ListenerImplementation implements ITestListener {
	/***
	 * This class is used to genrate extent report
	 */
	public ExtentReports report;
	public static ExtentTest logger;
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./reports/Suite.html");
		report=new ExtentReports();
		report.attachReporter(reporter);
	}

	public void onTestStart(ITestResult result) {
		logger=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "This test is passed " +result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "This test is failed " +result.getMethod().getMethodName());
		try {
			logger.addScreenCaptureFromPath(ScreenshotUtility.takingScreenshot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "This test is skipped " +result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
