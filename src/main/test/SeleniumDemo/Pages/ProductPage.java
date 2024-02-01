package SeleniumDemo.Pages;

import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@class = 'woocommerce-message']")
    private WebElement itemAddedToCartMessage;

    @FindBy(linkText = "View cart")
    private WebElement viewCart;

    @FindBy(name = "quantity")
    private WebElement addMoreProductsInput;

    @FindBy(xpath = "//p[@class='price']")
    private WebElement productCurrency;
    @FindBy(xpath = "//div[@id='tab-description']//p")
    private WebElement productDescription;
    @FindBy(xpath = "//sup[@class='count czr-wc-count']")
    private WebElement cartProductCount;
    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    private WebElement proceedToCheckoutButton;




     private WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ProductPage getProductDescription() {
        productDescription.getText();
        return new ProductPage(driver);
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
    public ProductPage addMoreProducts(String numberOfProducts) {
        SeleniumHelper.waitForClickable(addMoreProductsInput, driver);
        addMoreProductsInput.clear();
        addMoreProductsInput.sendKeys(numberOfProducts);
        return new ProductPage(driver);
    }
    public String getCartProductCount() {
        return cartProductCount.getText();
    }
    public BillingDetailsPage proceedToCheckout() {
        Actions action = new Actions(driver);
        WebElement hoverImage = driver.findElement(By.xpath("//i[@class='icn-shoppingcart']"));
        action.moveToElement(hoverImage).build().perform();
        SeleniumHelper.waitForClickable(proceedToCheckoutButton, driver);
        proceedToCheckoutButton.click();

        return new BillingDetailsPage(driver);
    }
}
