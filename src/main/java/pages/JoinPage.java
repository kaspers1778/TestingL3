package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class JoinPage {

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//select[@id='BirthDay']")
    WebElement birthDayInput;

    @FindBy(xpath = "//select[@id='BirthMonth']")
    WebElement birthMonthInput;

    @FindBy(xpath = "//select[@id='BirthYear']")
    WebElement birthYearInput;

    @FindBy(xpath = "//input[@id='register']")
    WebElement joinButton;

    @FindBy(xpath = "//div[@class='error-block']//li[text()='Sorry, we cannot create your account right now']")
    WebElement registrationMessageBox;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement invalidEmailMassage;

}
