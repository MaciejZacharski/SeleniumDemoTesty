package SeleniumDemo.Tests;

import SeleniumDemo.Models.Products;
import SeleniumDemo.Pages.BillingDetailsPage;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductTest extends BaseTest {

    @Test
    public void checkAddedProductMessage() throws IOException {


        ExtentTest test = extentReports.createTest("Check Added Product Message Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts(number)
                .addToCart();
        test.log(Status.PASS, "Products added", SeleniumHelper.getScreenshot(driver));


        Assert.assertTrue(productPage.getItemAddedToCartMessage().contains(number + " × “BDD Cucumber” have been added to your cart."));
    }

    @Test
    public void checkUpperCornerCartUpdate() throws IOException {


        ExtentTest test = extentReports.createTest("Check Upper Corner Cart Update Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts(number)
                .addToCart()
                .addToCart();
        test.log(Status.PASS, "Upper Corner Cart Update", SeleniumHelper.getScreenshot(driver));


        Assert.assertEquals(productPage.getCartProductCount(), "6");
    }

    @Test
    public void proceedToCheckoutFromProductPage() throws IOException {


        ExtentTest test = extentReports.createTest("Proceed To Checkout From Product Page Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts(number)
                .addToCart();
        test.log(Status.PASS, "Products added", SeleniumHelper.getScreenshot(driver));

        BillingDetailsPage billingDetailsPage = productPage.proceedToCheckout();

        test.log(Status.PASS, "Billing Details Screen", SeleniumHelper.getScreenshot(driver));


        Assert.assertTrue(billingDetailsPage.getEnterCouponLink().contains("Click here to enter your code"));
    }


}
