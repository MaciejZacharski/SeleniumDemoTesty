package SeleniumDemo.Tests;

import SeleniumDemo.Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
     driver =   DriverFactory.getDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("http://seleniumdemo.com/");

    }

    @AfterMethod
    public void tearDown() {
      //  driver.quit();

    }
}
