package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.LoggedUserPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterAndLoginTest extends BaseTest {


    int random = (int) (Math.random() * 1000);
    String email = "test" + random + "@gmail.com";

    @Test
    public void RegisterUserTest() throws IOException {

        ExtentTest test = extentReports.createTest("Register User Test");

        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUserValidData(email, "Test_123!!")
                .getDashboardLink();


        test.log(Status.PASS, "User registered Dashboard Loaded", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");


    }

    @Test
    public void RegisterUserWithExistingEmailTest() throws IOException {
        ExtentTest test = extentReports.createTest("Register User With Existing Email Test");

        WebElement emailError = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidEmail(email, "Test_123!!")
                .getError();
        test.log(Status.PASS, "Error message displayed", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(emailError.getText().contains("An account is already registered with your email address. Please log in."));


    }
    @Test(priority = 2)
    public void LoginUserTest() throws IOException {
        ExtentTest test = extentReports.createTest("Login User Test");

        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .loginUserValidData(email, "Test_123!!")
                .getDashboardLink();
        test.log(Status.PASS, "Logged user Dashboard", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");


    }

    @Test
    public void LoginUserWithInvalidEmailTest() throws IOException {
        ExtentTest test = extentReports.createTest("Login User With Invalid Email Test");

        WebElement loginError = new HomePage(driver).openMyAccountPage()
                .loginUserInvalidEmail("test12387@gmail.com", "Test_123!!")
                .getError();
        test.log(Status.PASS, "Error message for incorrect login", SeleniumHelper.getScreenshot(driver));
        Assert.assertTrue(loginError.getText().contains("Incorrect username or password."), "Expected Error Text dosent match");


    }

}
