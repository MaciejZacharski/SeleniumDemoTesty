package SeleniumDemo.Tests;

import SeleniumDemo.Models.Customer;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.OrderPageDetails;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    @Test
    public void BuyRandomItem() throws InterruptedException {

        int random = (int) (Math.random()*1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        OrderPageDetails orderPageDetails = new HomePage(driver).openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addToCart()
                .viewCart()
                .proceedCheckout().fillInCustomerForm(customer);





    Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
    Assert.assertEquals(orderPageDetails.getProductName(), "Java Selenium WebDriver");
    }
}
