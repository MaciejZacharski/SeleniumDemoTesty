package SeleniumDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {

    @FindBy(xpath = "//p[text()=': please fill the required fields (name, email).']")
    private WebElement emptyReviewErrorMessage;

    public ErrorPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public String getEmptyReviewErrorMessage() {
        return emptyReviewErrorMessage.getText();
    }

}
