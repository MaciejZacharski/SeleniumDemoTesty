package SeleniumDemo.Pages;

import SeleniumDemo.Models.ProductFilters;
import SeleniumDemo.Models.Products;
import SeleniumDemo.Utils.SeleniumHelper;
import com.mongodb.client.model.Filters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListPage {

    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;

    @FindBy(linkText = "View cart")
    private WebElement viewCart;

    @FindBy(xpath = "//h1[text()='Shop']")
    private WebElement shopHeader;

    @FindBy(name = "orderby")
    private WebElement filterSelect;

    @FindBy(xpath = "//ul[@class='products columns-4']/li[1]/a[1]/h2")
    private WebElement firstProductOnList;

    @FindBy(xpath = "//ul[@class='products columns-4']/li[2]/a[1]/h2")
    private WebElement secondProductOnList;

    @FindBy(css = ".woocommerce-mini-cart__empty-message")
    private WebElement emptyCartMessage;
    @FindBy(xpath = "//i[@class='icn-shoppingcart']")
    private WebElement cartImage;


    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getShopHeader() {
        return shopHeader.getText();
    }

    public ProductListPage addToCart() {
        SeleniumHelper.waitForClickable(addToCart, driver);
        addToCart.click();
        return new ProductListPage(driver);
    }

    public CartPage viewCart() {
        SeleniumHelper.waitForClickable(viewCart, driver);
        viewCart.click();
        return new CartPage(driver);
    }

    public ProductPage openProduct(Products product) {

        driver.findElement(By.xpath("//h2[text()='" + product.getName() + "']")).click();
        return new ProductPage(driver);

    }

    public ProductListPage filterProductsByPopularity(ProductFilters filter) {

        Select filters = new Select(filterSelect);
        filters.selectByValue("date");
        filters.selectByValue(filter.getName());


        return new ProductListPage(driver);
    }


    public String checkFilterForFirstProduct() {

        return firstProductOnList.getText();
    }

    public String checkFilterForSecondProduct() {

        return secondProductOnList.getText();
    }

    public String getEmptyCartMessage() {


        return emptyCartMessage.getText();
    }
    public ProductListPage hoverCartImage() {
    Actions hoverCartImage = new Actions(driver);
    hoverCartImage.moveToElement(cartImage).perform();

        return new ProductListPage(driver);
    }


}
