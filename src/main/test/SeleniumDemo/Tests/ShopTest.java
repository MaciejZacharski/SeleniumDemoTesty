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
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class ShopTest extends BaseTest {

    @Test
    public void BuyJavaSeleniumWebDriverTest() throws IOException {
        ExtentTest test = extentReports.createTest("Buy Java Selenium WebDriver Test");
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        BillingDetailsPage billingDetailsPage = new HomePage(driver).openShopPage()
                .openProduct(Products.JAVASELENIUMWEBDRIVER)
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);
        test.log(Status.PASS, "Filled Customer form", SeleniumHelper.getScreenshot(driver));
       OrderPageDetails orderPageDetails = billingDetailsPage.clickOnPlaceOrder();

        test.log(Status.PASS, "Order Page Loaded", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameSelenium(), "Java Selenium WebDriver");
    }
    @Test
    public void BuyBDDCucumberTest() throws IOException {
        ExtentTest test = extentReports.createTest("BuyBDDCucumberTest");
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        BillingDetailsPage billingDetailsPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);
        test.log(Status.PASS, "Filled Customer form", SeleniumHelper.getScreenshot(driver));
        OrderPageDetails orderPageDetails = billingDetailsPage.clickOnPlaceOrder();

        test.log(Status.PASS, "Order Page Loaded", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameBDDCucumber(), "BDD Cucumber");
    }
    @Test
    public void BuyGitBasicsTest() throws IOException {
        ExtentTest test = extentReports.createTest("Buy Git Basics Test");
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        BillingDetailsPage billingDetailsPage = new HomePage(driver).openShopPage()
                .openProduct(Products.GITBASICS)
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);
        test.log(Status.PASS, "Filled Customer form", SeleniumHelper.getScreenshot(driver));
        OrderPageDetails orderPageDetails = billingDetailsPage.clickOnPlaceOrder();

        test.log(Status.PASS, "Order Page Loaded", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameGIT(), "GIT basics");
    }
    @Test
    public void Buy2BDDCucumberTest() throws IOException {
        ExtentTest test = extentReports.createTest("Buy 2BDD Cucumber Test");
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        Customer customer = new Customer();
        customer.setEmailAddress("specific@gmail.com");


        BillingDetailsPage billingDetailsPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts("2")
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);
        test.log(Status.PASS, "Filled Customer form", SeleniumHelper.getScreenshot(driver));
        OrderPageDetails orderPageDetails = billingDetailsPage.clickOnPlaceOrder();

        test.log(Status.PASS, "Order Page Loaded", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderPageDetails.getThankYouText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderPageDetails.getProductNameBDDCucumber(), "BDD Cucumber");
    }

    @Test
    public void placeOrderWithEmptyCustomerFormTest() throws IOException {
        ExtentTest test = extentReports.createTest("Place Order With Empty Customer Form Test");
        Customer customer = new Customer();
        customer.setEmailAddress("");
        customer.setFirstName("");
        customer.setLastName("");
        customer.setCityName("");
        customer.setPostalCode("");
        customer.setPhoneNumber("");
        customer.setAddress1("");
        customer.setAddress2("");


        BillingDetailsPage billingDetailsPage = new HomePage(driver).openShopPage()
                .openProduct(Products.BDDCUCUMBER)
                .addMoreProducts("2")
                .addToCart()
                .viewCart()
                .proceedCheckout()
                .fillInCustomerForm(customer);
        test.log(Status.PASS, "Filled Customer form", SeleniumHelper.getScreenshot(driver));

        List<WebElement> errors =   billingDetailsPage.clickOnPlaceOrderWithEmptyCustomerForm().getErrorMessages();
        test.log(Status.PASS, "Error Messages Shown", SeleniumHelper.getScreenshot(driver));


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errors.size(), 7);
        softAssert.assertEquals(errors.get(0).getText(), "Billing First name is a required field.");
        softAssert.assertEquals(errors.get(1).getText(), "Billing Last name is a required field.");
        softAssert.assertEquals(errors.get(2).getText(), "Billing Street address is a required field.");
        softAssert.assertEquals(errors.get(3).getText(), "Billing Town / City is a required field.");
        softAssert.assertEquals(errors.get(4).getText(), "Billing Phone is a required field.");
        softAssert.assertEquals(errors.get(5).getText(), "Billing Email address is a required field.");
        softAssert.assertEquals(errors.get(6).getText(), "Billing Postcode / ZIP is not a valid postcode / ZIP.");



    }



}
