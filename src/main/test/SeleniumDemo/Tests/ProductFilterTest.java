package SeleniumDemo.Tests;

import SeleniumDemo.Models.ProductFilters;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.ProductListPage;
import SeleniumDemo.Utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductFilterTest extends BaseTest {

    @Test
    public void popularityFilter() throws IOException {
        ExtentTest test = extentReports.createTest("Popularity Filter Test");

        ProductListPage page = new HomePage(driver).openShopPage();
        test.log(Status.PASS, "Products order before filter", SeleniumHelper.getScreenshot(driver));
                page.filterProductsByPopularity(ProductFilters.popularity);
        test.log(Status.PASS, "Products order after filter", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(page.checkFilterForFirstProduct(), "Java Selenium WebDriver");
        Assert.assertEquals(page.checkFilterForSecondProduct(), "BDD Cucumber");


    }
    @Test
    public void latestDateFilter() throws IOException {
        ExtentTest test = extentReports.createTest("Latest Date Test");

        ProductListPage page = new HomePage(driver).openShopPage();
        test.log(Status.PASS, "Products order before filter", SeleniumHelper.getScreenshot(driver));
                page.filterProductsByPopularity(ProductFilters.date);
        test.log(Status.PASS, "Products order after filter", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(page.checkFilterForFirstProduct(), "BDD Cucumber");
        Assert.assertEquals(page.checkFilterForSecondProduct(), "GIT basics");


    }
    @Test
    public void priceAscendingFilter() throws IOException {
        ExtentTest test = extentReports.createTest("Price Ascending Filter Test");

        ProductListPage page = new HomePage(driver).openShopPage();
        test.log(Status.PASS, "Products order before filter", SeleniumHelper.getScreenshot(driver));
                page.filterProductsByPopularity(ProductFilters.price);
        test.log(Status.PASS, "Products order after filter", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(page.checkFilterForFirstProduct(), "Java Selenium WebDriver");
        Assert.assertEquals(page.checkFilterForSecondProduct(), "GIT basics");


    }
    @Test
    public void ratingFilter() throws IOException {
        ExtentTest test = extentReports.createTest("Rating Filter Test");

        ProductListPage page = new HomePage(driver).openShopPage();
        test.log(Status.PASS, "Products order before filter", SeleniumHelper.getScreenshot(driver));
                page.filterProductsByPopularity(ProductFilters.rating);
        test.log(Status.PASS, "Products order after filter", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(page.checkFilterForFirstProduct(), "Java Selenium WebDriver");
        Assert.assertEquals(page.checkFilterForSecondProduct(), "GIT basics");


    }
    @Test
    public void priceDescendingFilter() throws IOException {
        ExtentTest test = extentReports.createTest("Price Descending Filter Test");

        ProductListPage page = new HomePage(driver).openShopPage();
        test.log(Status.PASS, "Products order before filter", SeleniumHelper.getScreenshot(driver));
                page.filterProductsByPopularity(ProductFilters.priceDesc);
        test.log(Status.PASS, "Products order after filter", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(page.checkFilterForFirstProduct(), "BDD Cucumber");
        Assert.assertEquals(page.checkFilterForSecondProduct(), "GIT basics");


    }
}
