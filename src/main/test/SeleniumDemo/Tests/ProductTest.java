package SeleniumDemo.Tests;

import SeleniumDemo.Models.Products;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductTest extends BaseTest{

    @Test
    public void checkAddedProductMessage() throws IOException {

        ExtentTest test = extentReports.createTest("checkAddedProductMessage");

        ProductPage productPage =  new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts("3")
                .addToCart();
        test.log(Status.PASS, "Products added", SeleniumHelper.getScreenshot(driver));



        Assert.assertTrue(productPage.getItemAddedToCartMessage().contains("3 × “BDD Cucumber” have been added to your cart."));
    }

}
