import Models.Products;
import Pages.BillingDetailsPage;
import Pages.ErrorPage;
import Pages.HomePage;
import Pages.ProductPage;
import Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductTest extends BaseTest {

    @Test
    public void checkAddedProductMessageTest() throws IOException {


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
    public void checkUpperCornerCartUpdateTest() throws IOException {


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
    public void proceedToCheckoutFromProductPageTest() throws IOException {


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
    @Test
    public void addNewProductReviewTest() throws IOException {


        ExtentTest test = extentReports.createTest("Add New Product Review Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .clickOnReviews();
        test.log(Status.PASS, "Reviews tab opened", SeleniumHelper.getScreenshot(driver));
                productPage.addReview("Super course", "Jan", "jan@test.com");

        test.log(Status.PASS, "Reviews added", SeleniumHelper.getScreenshot(driver));

    }
    @Test
    public void addNewProductReviewNoRatingTest() throws IOException {


        ExtentTest test = extentReports.createTest("Add New Product Review No Rating Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .clickOnReviews();
        test.log(Status.PASS, "Reviews tab opened", SeleniumHelper.getScreenshot(driver));
        productPage.addReviewNoRating("Super course", "Jan", "jan@test.com");


        test.log(Status.PASS, "Reviews added", SeleniumHelper.getScreenshot(driver));


    }
    @Test
    public void addNewEmptyProductReviewTest() throws IOException {


        ExtentTest test = extentReports.createTest("Add New Empty Product Review Test");

        String number = "3";
        ProductPage productPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .clickOnReviews();
        test.log(Status.PASS, "Reviews tab opened", SeleniumHelper.getScreenshot(driver));
     ErrorPage error = productPage.addEmptyReview();


        test.log(Status.PASS, "Reviews added", SeleniumHelper.getScreenshot(driver));
        Assert.assertTrue(error.getEmptyReviewErrorMessage().contains("name, email"));

    }


}
