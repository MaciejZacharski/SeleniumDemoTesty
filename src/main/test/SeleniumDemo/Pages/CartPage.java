package SeleniumDemo.Pages;

import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    private WebElement checkoutButton;
    @FindBy(xpath = "//a[@class='remove']")
    private WebElement removeButton;
    @FindBy(xpath = "//p[@class='cart-empty']")
    private WebElement emptyCart;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    private WebElement backToShopButton;

    @FindBy(linkText = "Java Selenium WebDriver")
    private WebElement productName;
    @FindBy(linkText = "Undo?")
    private WebElement undoButton;
    @FindBy(xpath = "//div[@class='quantity']//input")
    private WebElement addMoreProductsInput;
    @FindBy(name = "update_cart")
    private WebElement updateCartButton;

    @FindBy(xpath = "//td[@class='product-subtotal']//span[@class='woocommerce-Price-amount amount']")
    private WebElement priceAmount;
    @FindBy(xpath = "//td[@class='product-subtotal']//span[@class='woocommerce-Price-currencySymbol']")
    private WebElement currencySymbol;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement cartUpdated;
    @FindBy(id = "coupon_code")
    private WebElement couponCodeInput;
    @FindBy(name = "apply_coupon")
    private WebElement applyCouponButton;
    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']//li")
    private WebElement couponErrorMessage;

private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public String getCartUpdateConfirmationMessage() {
        return cartUpdated.getText();
    }

    public CartPage removeProduct() {
        SeleniumHelper.waitForClickable(removeButton, driver);
        removeButton.click();
        return new CartPage(driver);
    }
    public CartPage undoProductRemoval() {
        SeleniumHelper.waitForClickable(undoButton, driver);
        undoButton.click();
        return new CartPage(driver);
    }
    public String getQuantity() {
        return addMoreProductsInput.getAttribute("value");
    }
    public String getTotalProductPrice() {
        return priceAmount.getText() + currencySymbol.getText();
    }

    public String getEmptyCartText() {

     return emptyCart.getText();

    }
    public String getProductName() {

        return productName.getText();

    }
    public CartPage updateCart() {
        SeleniumHelper.waitForClickable(updateCartButton, driver);
        updateCartButton.click();
        return new CartPage(driver);
    }
    public boolean checkBackToShopButtonPresent() {
      return   backToShopButton.isDisplayed();
            }
    public BillingDetailsPage proceedCheckout() {
        SeleniumHelper.waitForClickable(checkoutButton, driver);
        checkoutButton.click();
        return new BillingDetailsPage(driver);
    }
    public ProductListPage backToShop() {
        SeleniumHelper.waitForClickable(backToShopButton, driver);
        backToShopButton.click();
        return new ProductListPage(driver);
    }
    public CartPage addMoreProducts(String numberOfProducts) {

        addMoreProductsInput.clear();
        addMoreProductsInput.sendKeys(numberOfProducts);
        return new CartPage(driver);
    }
    public CartPage enterCouponCode(String coupon) {

        couponCodeInput.sendKeys(coupon);

        return new  CartPage(driver);
    }
    public CartPage applyCoupon() {
        SeleniumHelper.waitForClickable(applyCouponButton, driver);
        applyCouponButton.click();
        return new CartPage(driver);
    }
    public String getCouponErrorMessage() {
      return couponErrorMessage.getText();
    }

}
