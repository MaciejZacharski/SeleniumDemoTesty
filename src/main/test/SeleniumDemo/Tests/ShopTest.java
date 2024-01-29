package SeleniumDemo.Tests;

import SeleniumDemo.Models.Customer;
import SeleniumDemo.Pages.HomePage;
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
        customer.setFirstName("Janusz");
        customer.setLastName("Marski");
        customer.setAddress1("ul. Morska");
        customer.setAddress2("22");
        customer.setCountryNameSelect("Poland");
        customer.setCityName("Warszawa");
        customer.setPostalCode("22-222");
        customer.setPhoneNumber("123443211");
        customer.setEmailAddress(email);


     new HomePage(driver).openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addToCart()
                .viewCart()
                .proceedCheckout().fillInCustomerForm(customer);
//     String message = new ProductPage(driver).getItemAddedToCartMessage();

  //   Assert.assertTrue(message.contains("“Java Selenium WebDriver” has been added to your cart."));





    }
}
