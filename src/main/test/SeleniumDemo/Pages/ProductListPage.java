package SeleniumDemo.Pages;

import SeleniumDemo.Models.Products;
import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;

    @FindBy(linkText = "View cart")
    private WebElement viewCart;

    @FindBy(xpath = "//h1[text()='Shop']")
    private WebElement shopHeader;

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
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

        driver.findElement(By.xpath("//h2[text()='"+ product.getName() +"']")).click();
        return new ProductPage(driver);

    }



}
