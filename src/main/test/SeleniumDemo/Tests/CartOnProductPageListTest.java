package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartOnProductPageListTest extends BaseTest {

    @Test
    public void checkEmptyCartMessage() throws IOException {
        ExtentTest test = extentReports.createTest("Check Empty Cart Message Test");


        ProductListPage page = new HomePage(driver).openShopPage().hoverCartImage();
        test.log(Status.PASS, "Empty cart Message displayed", SeleniumHelper.getScreenshot(driver));


        Assert.assertEquals(page.getEmptyCartMessage(), "No products in the cart.");
    }
}
