package Framework.ExtendReport_TestngListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {

	public WebDriver driver;
	ExtentSparkReporter reptobj;
	ExtentReports extentobj;

	@BeforeTest
	public void config() {
		// ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir") + "/reports/index.html";

		reptobj = new ExtentSparkReporter(path);
		reptobj.config().setReportName("Aparna test Autonmation Result");
		reptobj.config().setDocumentTitle("Test result");

		extentobj = new ExtentReports();
		extentobj.attachReporter(reptobj);
		extentobj.setSystemInfo("Tester", "Aparna Choudhary");

	}

	@Test
	public void idnitialDemo() {

		ExtentTest test = extentobj.createTest("idnitialDemo");

		System.setProperty("webdriver.chrome.driver",
				"/Users/aparnachdhry/Documents/Software/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.fail("Result do not match");
		
		extentobj.flush();

	}

}
