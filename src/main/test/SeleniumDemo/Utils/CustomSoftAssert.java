package SeleniumDemo.Utils;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CustomSoftAssert extends SoftAssert {

    protected static ExtentReports extentReports;

    private WebDriver driver;

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand)  {
        try {
            SeleniumHelper.getScreenshot(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {

        try {
            SeleniumHelper.getScreenshot(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
