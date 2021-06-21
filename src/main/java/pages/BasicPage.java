package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class BasicPage {

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    WebElement accountItem;


    @FindBy(xpath = "//button[@data-testid='myAccountIcon']/span[@type='accountFilled']")
    WebElement myAccountIconFilled;


    @FindBy(xpath = "//a[@data-testid='signup-link']")
    WebElement joinLink;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    WebElement signInLink;

    @FindBy(xpath = "//button[@data-testid='signout-link']")
    WebElement singOutButton;
}
