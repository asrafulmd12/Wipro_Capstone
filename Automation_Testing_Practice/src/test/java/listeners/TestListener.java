package listeners;

import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import base.BaseTest;
import utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private ExtentReports extent;
	private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    	
    	extent = ExtentManager.getExtentReport();

        System.out.println("===== TEST SUITE STARTED =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
    	
    	test = extent.createTest(
                result.getMethod().getMethodName());

        System.out.println(
                "STARTED : "
                        + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
    	test.pass("Test Passed");

        System.out.println(
                "PASSED : "
                        + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	 test.fail(result.getThrowable());

        System.out.println(
                "FAILED : "
                        + result.getMethod().getMethodName());

        System.out.println(
                "REASON : "
                        + result.getThrowable());
        
        Object currentClass = result.getInstance();

        WebDriver driver =
                ((BaseTest) currentClass).getDriver();

        ScreenshotUtil.captureScreenshot(
                driver,
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	
    	test.skip("Test Skipped");

        System.out.println(
                "SKIPPED : "
                        + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	
    	extent.flush();

        System.out.println("===== TEST SUITE FINISHED =====");
    }
}