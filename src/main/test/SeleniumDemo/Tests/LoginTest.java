package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void LoginUserTest() {


        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .loginUserValidData("test123@gmail.com", "Test_123!!")
                .getDashboardLink();


        Assert.assertEquals(dashboardLink.getText(), "Dashboard");


    }

    @Test
    public void RegisterUserWithExistingEmailTest() {


        WebElement loginError = new HomePage(driver).openMyAccountPage()
                .loginUserInvalidEmail("test12387@gmail.com", "Test_123!!")
                .getError();

        Assert.assertTrue(loginError.getText().contains("Incorrect username or password."), "Expected Error Text dosent match");


    }
}
