import Utils.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentHtmlReporter htmlReporter;

    protected static ExtentReports extentReports;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");

    }

    @AfterMethod
    public void tearDown() {
          driver.quit();

    }
    @BeforeSuite
    public void beforeSuite() {
        htmlReporter = new ExtentHtmlReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite() {
        htmlReporter.flush();
        extentReports.flush();

    }
}
