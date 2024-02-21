package SeleniumDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


    @FindBy(id = "reg_email")
    private WebElement registrationEmailInput;
    @FindBy(id = "reg_password")
    private WebElement registrationPasswordInput;
    @FindBy(name = "register")
    private WebElement registrationButton;

    @FindBy(xpath = "//ul[@class= 'woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement loginUsernameInput;
    @FindBy(id = "password")
    private WebElement loginPasswordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {

        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidEmail(String email, String password) {

        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {

        registrationEmailInput.sendKeys(email);
        registrationPasswordInput.sendKeys(password);
        Actions actions = new Actions(driver);
        actions.moveToElement(registrationButton).click().perform();

    }

    private void loginUser(String email, String password) {

        loginUsernameInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().perform();

    }

    public LoggedUserPage loginUserValidData(String email, String password) {

        loginUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInvalidEmail(String email, String password) {

        loginUser(email, password);
        return this;
    }
}
