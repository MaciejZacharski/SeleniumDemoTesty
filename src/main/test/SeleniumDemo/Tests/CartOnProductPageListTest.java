package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Utils.CustomSoftAssert;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Objects;

public class CartOnProductPageListTest extends BaseTest {

    @Test
    public void checkEmptyCartMessage() throws IOException {
        ExtentTest test = extentReports.createTest("Check Empty Cart Message Test");


        ProductListPage page = new HomePage(driver).openShopPage().hoverCartImage();
        String emptyCartMessage = page.getEmptyCartMessage();


        if ((emptyCartMessage != "No products in the cart.")) ;
        {
            test.fail("Empty cart Message displayed incorrectly", SeleniumHelper.getScreenshot(driver));
        }
        test.pass("Empty cart Message displayed", SeleniumHelper.getScreenshot(driver));


        Assert.assertEquals(emptyCartMessage, "No products in the cart.");


    }
}
