package SeleniumDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


  @FindBy(id = "reg_email")
  private WebElement registrationEmailInput;
    @FindBy(id = "reg_password")
    private WebElement registrationPasswordInput;
    @FindBy(name = "register")
    private WebElement registrationButton;



    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    public LoggedUserPage registerUser(String email, String password) {

       registrationEmailInput.sendKeys(email);
       registrationPasswordInput.sendKeys(password);
       registrationButton.click();
       return new LoggedUserPage(driver);
    }
}
