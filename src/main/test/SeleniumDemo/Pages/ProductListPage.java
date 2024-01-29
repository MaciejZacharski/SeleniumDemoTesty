package SeleniumDemo.Pages;

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


    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
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

    public ProductPage openProduct(String title) {
        driver.findElement(By.xpath("//h2[text()='"+ title +"']")).click();
        return new ProductPage(driver);

    }
}
