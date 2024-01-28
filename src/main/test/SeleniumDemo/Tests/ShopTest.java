package SeleniumDemo.Tests;

import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    @Test
    public void BuyRandomItem() {


     new HomePage(driver).openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addToCart()
                .viewCart()
                .proceedCheckout();
//     String message = new ProductPage(driver).getItemAddedToCartMessage();

  //   Assert.assertTrue(message.contains("“Java Selenium WebDriver” has been added to your cart."));





    }
}
