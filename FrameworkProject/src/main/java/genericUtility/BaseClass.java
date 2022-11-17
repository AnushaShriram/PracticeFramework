package genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest Logger;
	
	
	
	@BeforeSuite
	public void launchingBrowser() {
		reporter=new ExtentSparkReporter("./Reports/extentdemo.html");
		report=new ExtentReports();
		report.attachReporter(reporter);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void beforeTest() {
		Logger=report.createTest("testcase1");
	}
	
	
	@BeforeClass
	public void navigatingToApp() {
		driver.get("https://demowebshop.tricentis.com/");
		Logger.log(Status.INFO, "succesfully navigated to application");
	}
	@BeforeMethod
	public void started() {
		Logger.log(Status.INFO, "succesfully started");
	}

	@AfterMethod
	public void checking(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			String path = ScreenshotUtility.takeScreenShotMethod(result.getName());
			Logger.log(Status.FAIL, "the test script"+result.getName()+"is failed");
			Logger.addScreenCaptureFromPath(path);
		}
	}

	@AfterClass
	public void logOut() {
		System.out.println("logged out");
		Logger.log(Status.INFO, "logged out from the application");
	}

	@AfterSuite
	public void tearDownTheBrowser() {
		driver.quit();
		Logger.log(Status.INFO, "closed the browser");
	}

}