import Pages.HomePage;
import Pages.ProductListPage;
import Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

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
