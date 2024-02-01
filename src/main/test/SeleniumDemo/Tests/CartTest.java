package SeleniumDemo.Tests;

import SeleniumDemo.Models.Products;
import SeleniumDemo.Pages.CartPage;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartTest extends BaseTest {
    @Test
    public void checkEmptyCartAfterRemovalTest() throws IOException {
        ExtentTest test = extentReports.createTest("check Empty Cart After Removal Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts("3")
                .addToCart()
                .viewCart()
                .removeProduct();
        boolean present = cartPage.checkBackToShopButtonPresent();
        if (present) {
            test.log(Status.PASS, "Product removed", SeleniumHelper.getScreenshot(driver));
        }


        Assert.assertEquals(cartPage.getEmptyCartText(), "Your cart is currently empty.");
    }

    @Test
    public void backToShopTest() throws IOException {
        ExtentTest test = extentReports.createTest("back To Shop Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.GITBASICS)
                .addMoreProducts("1")
                .addToCart()
                .viewCart()
                .removeProduct();
        boolean present = cartPage.checkBackToShopButtonPresent();
        if (present) {
            test.log(Status.PASS, "EmptyShopCart", SeleniumHelper.getScreenshot(driver));
        }
        Assert.assertTrue(present);
        ProductListPage productListPage = cartPage.backToShop();
        test.log(Status.PASS, "Back Shop page", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(productListPage.getShopHeader(), "Shop");

    }

    @Test
    public void checkIfCorrectProductWasAddedTest() throws IOException {
        ExtentTest test = extentReports.createTest("check If Correct Product Was Added Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addMoreProducts("1")
                .addToCart()
                .viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Java Selenium WebDriver");

        test.log(Status.PASS, "Cart with correct product", SeleniumHelper.getScreenshot(driver));


    }

    @Test
    public void retrieveProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Retrieve Product Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addMoreProducts("1")
                .addToCart()
                .viewCart()
                .removeProduct();
        boolean present = cartPage.checkBackToShopButtonPresent();
        if (present) {
            test.log(Status.PASS, "Cart with removed product", SeleniumHelper.getScreenshot(driver));
        }

        cartPage.undoProductRemoval();
        Assert.assertEquals(cartPage.getProductName(), "Java Selenium WebDriver");


        test.log(Status.PASS, "Product retrieved", SeleniumHelper.getScreenshot(driver));


    }
    @Test
    public void AddProductInCartAndUpdateCartTest() throws IOException {
        ExtentTest test = extentReports.createTest("Add Product In Cart And Update Cart Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addMoreProducts("1")
                .addToCart()
                .viewCart();
        test.log(Status.PASS, "Cart with 1 product", SeleniumHelper.getScreenshot(driver));
                cartPage.addMoreProducts("3");



        Assert.assertEquals(cartPage.getQuantity(), "3");
        test.log(Status.PASS, "Cart with extra products", SeleniumHelper.getScreenshot(driver));


    }
    @Test
    public void CheckPriceUpdateTest() throws IOException {
        ExtentTest test = extentReports.createTest("Check Price Update Test");


        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addMoreProducts("1")
                .addToCart()
                .viewCart();
        test.log(Status.PASS, "Cart with 1 product", SeleniumHelper.getScreenshot(driver));
        cartPage.addMoreProducts("3")
                .updateCart();


        Assert.assertEquals(cartPage.getCartUpdateConfirmationMessage(), "Cart updated.");
        Assert.assertEquals(cartPage.getTotalProductPrice(), "3,00 złzł");
        test.log(Status.PASS, "Total price updated", SeleniumHelper.getScreenshot(driver));


    }
    @Test
    public void CheckIncorrectCouponErrorTest() throws IOException {
        ExtentTest test = extentReports.createTest("Check Incorrect Coupon Error");

        String coupon = "Marzec";
        CartPage cartPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addMoreProducts("1")
                .addToCart()
                .viewCart()
                        .enterCouponCode(coupon)
                                .applyCoupon();



        Assert.assertEquals(cartPage.getCouponErrorMessage(),"Coupon " + "\"" + coupon.toLowerCase() + "\"" + " does not exist!");

        test.log(Status.PASS, "Coupon Error Message displayed", SeleniumHelper.getScreenshot(driver));


    }
}
