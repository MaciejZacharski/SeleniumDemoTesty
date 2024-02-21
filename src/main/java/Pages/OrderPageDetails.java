package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageDetails {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement thankYouForYourOrder;
    @FindBy(linkText = "Java Selenium WebDriver")
    private WebElement productNameSelenium;
    @FindBy(linkText = "BDD Cucumber")
    private WebElement productNameBDDCucumber;
    @FindBy(linkText = "GIT basics")
    private WebElement productNameGIT;


    public OrderPageDetails(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public String getThankYouText() {
     return    thankYouForYourOrder.getText();
    }
    public String getProductNameSelenium() {
      return   productNameSelenium.getText();
    }
    public String getProductNameBDDCucumber() {
        return   productNameBDDCucumber.getText();
    }
    public String getProductNameGIT() {
        return   productNameGIT.getText();
    }

}
