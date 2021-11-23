package webTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import AllInOne.Allinone;
import login.Login;

public class EaseMyTripBase {
	protected static WebDriver webDriver;
	//protected static ExtentReports ex;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest test; 
	public Scanner sc = new Scanner(System.in);
	@BeforeClass
	public static void setUpBeforeClass() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/drivers/chromedriver.exe");
		webDriver = new ChromeDriver(op);
		webDriver.manage().window().maximize();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Login.html");
		htmlReporter.config().setDocumentTitle("Login EaseMyTrip");
        htmlReporter.config().setReportName("Login");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Tester Name", "Neha Kamboj");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
			String screenshotPath = Allinone.getScreenshot(webDriver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		extent.flush();
		Thread.sleep(2000);
		webDriver.quit();
	}

}