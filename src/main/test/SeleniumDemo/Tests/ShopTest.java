package SeleniumDemo.Tests;

import SeleniumDemo.Models.Customer;
import SeleniumDemo.Models.Products;
import SeleniumDemo.Pages.*;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShopTest extends BaseTest {

    @Test
    public void BuyJavaSeleniumWebDriver()  {

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        OrderPageDetails orderPageDetails = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addToCart()
                .viewCart()
                .proceedCheckout().fillInCustomerForm(customer);


        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameSelenium(), "Java Selenium WebDriver");
    }
    @Test
    public void BuyBDDCucumber()  {

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        OrderPageDetails orderPageDetails = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addToCart()
                .viewCart()
                .proceedCheckout().fillInCustomerForm(customer);


        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameBDDCucumber(), "BDD Cucumber");
    }
    @Test
    public void BuyGitBasics()  {

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        OrderPageDetails orderPageDetails = new HomePage(driver).openShopPage()
                .openProduct(Products.GITBASICS)
                .addToCart()
                .viewCart()
                .proceedCheckout().fillInCustomerForm(customer);


        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameGIT(), "GIT basics");
    }
    @Test
    public void Buy2BDDCucumber()  {

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        OrderPageDetails orderPageDetails = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts("2")
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);


        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameBDDCucumber(), "BDD Cucumber");
    }



}
