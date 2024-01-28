package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.MyAccountPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void RegisterUserTest() {
        MyAccountPage myAccountPage = new HomePage(driver).openMyAccountPage();
        myAccountPage.registerUser("test123@test.com", "Test_123!!");



    }
}
