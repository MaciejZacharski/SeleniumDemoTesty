package SeleniumDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageDetails {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement thankYouForYourOrder;
    @FindBy(linkText = "Java Selenium WebDriver")
    private WebElement productName;
    public OrderPageDetails(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public String getThankYouText() {
     return    thankYouForYourOrder.getText();
    }
    public String getProductName() {
      return   productName.getText();
    }

}
