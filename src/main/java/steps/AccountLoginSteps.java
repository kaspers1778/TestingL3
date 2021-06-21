package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountLoginPage;
import utils.Driver;

public class AccountLoginSteps {
    private WebDriver driver= Driver.getDriver();

    private AccountLoginPage accountLoginPage=PageFactory.initElements(driver,AccountLoginPage.class);

    public void setLogin(String login){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(accountLoginPage.getEmailInputField()));
        accountLoginPage.getEmailInputField().sendKeys(login);
    }

    public void setPassword(String password){
        accountLoginPage.getPasswordInputField().sendKeys(password);
    }

    public void loginInAccount(){
        accountLoginPage.getSignInButton().click();
    }

    public boolean messageWrongSignIn(){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(accountLoginPage.getMassageWrongSingIn()));
            WebElement messageBox = accountLoginPage.getMassageWrongSingIn();
            return messageBox.isDisplayed();

    }

}
