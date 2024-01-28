package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void RegisterUserTest() {

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUserValidData(email, "Test_123!!")
                .getDashboardLink();


        Assert.assertEquals(dashboardLink.getText(), "Dashboard");


    }

    @Test
    public void RegisterUserWithExistingEmailTest() {


        WebElement emailError = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidEmail("test123@gmail.com", "Test_123!!")
                .getError();

        Assert.assertTrue(emailError.getText().contains("An account is already registered with your email address. Please log in."));


    }
}
