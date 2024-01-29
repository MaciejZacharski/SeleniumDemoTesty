package SeleniumDemo.Pages;

import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@class = 'woocommerce-message']")
    private WebElement itemAddedToCartMessage;

    @FindBy(linkText = "View cart")
    private WebElement viewCart;


     private WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addToCart() {
        SeleniumHelper.waitForClickable(addToCart, driver);
        addToCart.click();
        return new ProductPage(driver);
    }
    public String getItemAddedToCartMessage() {
     return itemAddedToCartMessage.getText();
    }
    public CartPage viewCart() {
        SeleniumHelper.waitForClickable(viewCart, driver);
        viewCart.click();
        return new CartPage(driver);
    }
}
