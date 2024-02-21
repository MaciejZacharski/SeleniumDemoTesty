package Pages;

import Models.Customer;
import Utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BillingDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;
    @FindBy(id = "billing_country")
    private WebElement countryNameSelect;
    @FindBy(id = "billing_address_1")
    private WebElement address1Input;
    @FindBy(id = "billing_address_2")
    private WebElement address2Input;
    @FindBy(id = "billing_postcode")
    private WebElement postalCodeInput;
    @FindBy(id = "billing_city")
    private WebElement cityNameInput;
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;
    @FindBy(id = "billing_phone")
    private WebElement phoneNumberInput;
    @FindBy(id = "billing_email")
    private WebElement emailAddressInput;
    @FindBy(linkText = "Click here to enter your code")
    private WebElement enterCouponLink;
    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private List<WebElement> errorMessages;
    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement mainHeader;


    private WebDriver driver;


    public BillingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BillingDetailsPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setAddress1Line(String address1Line) {
        address1Input.sendKeys(address1Line);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setAddress2Line(String address2Line) {
        address2Input.sendKeys(address2Line);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setEmailAddress(String emailAddress) {
        emailAddressInput.sendKeys(emailAddress);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setCity(String city) {
        cityNameInput.sendKeys(city);
        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage setCountry(String country) {
        Select countries = new Select(countryNameSelect);
        List<WebElement> countriesList = countries.getOptions();

        for (WebElement countryOption : countriesList)
            if (countryOption.getText().equals(country)) {
                return new BillingDetailsPage(driver);
            }

        return new BillingDetailsPage(driver);
    }

    public OrderPageDetails clickOnPlaceOrder() {
        SeleniumHelper.waitForClickable(placeOrderButton, driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(placeOrderButton).perform();
        SeleniumHelper.waitForIsPresent(By.id("place_order"), driver);
        SeleniumHelper.waitForClickable(placeOrderButton, driver);
        actions.click();

        return new OrderPageDetails(driver);
    }
    public BillingDetailsPage clickOnPlaceOrderWithEmptyCustomerForm() {
        SeleniumHelper.waitForClickable(placeOrderButton, driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(placeOrderButton);
        actions.perform();
        SeleniumHelper.waitForIsPresent(By.id("place_order"), driver);
        SeleniumHelper.waitForClickable(placeOrderButton, driver);
        placeOrderButton.click();

        return new BillingDetailsPage(driver);
    }

    public BillingDetailsPage fillInCustomerForm(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        address1Input.sendKeys(customer.getAddress1());
        address2Input.sendKeys(customer.getAddress2());
        Select countries = new Select(countryNameSelect);
        countries.selectByVisibleText(customer.getCountryNameSelect());
        postalCodeInput.sendKeys(customer.getPostalCode());
        cityNameInput.sendKeys(customer.getCityName());
        phoneNumberInput.sendKeys(customer.getPhoneNumber());
        emailAddressInput.sendKeys(customer.getEmailAddress());


        return new BillingDetailsPage(driver);
    }

    public String getEnterCouponLink() {
        return enterCouponLink.getText();
    }

    public List<WebElement> getErrorMessages() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainHeader).perform();
        SeleniumHelper.waitForIsPresent(By.xpath("//ul[@class='woocommerce-error']//li"), driver);

        return errorMessages;

    }
}
