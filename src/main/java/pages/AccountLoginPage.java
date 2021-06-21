package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class AccountLoginPage {
    @FindBy(xpath = "//input[@id='EmailAddress']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='signin']")
    WebElement signInButton;

    @FindBy(xpath = "//div[@class='error-block']//li")
    WebElement massageWrongSingIn;

}
