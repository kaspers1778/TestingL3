package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.JoinPage;
import utils.Driver;

public class JoinSteps {

    private WebDriver driver = Driver.getDriver();

    private JoinPage joinPage = PageFactory.initElements(driver, JoinPage.class);

    public void setLoginEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(joinPage.getEmailInput()));
        joinPage.getEmailInput().sendKeys(email);
    }

    private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void setFirstName(String firstName) {
        scrollTo(joinPage.getFirstNameInput());
        joinPage.getFirstNameInput().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        scrollTo(joinPage.getLastNameInput());
        joinPage.getLastNameInput().sendKeys(lastName);
    }

    public void setBirthDay(String birthDay) {
        scrollTo(joinPage.getBirthDayInput());
        joinPage.getBirthDayInput().sendKeys(birthDay);
    }

    public void setBirthMonth(String birthMonth) {
        scrollTo(joinPage.getBirthMonthInput());
        joinPage.getBirthMonthInput().sendKeys(birthMonth);
    }

    public void setBirthYear(String birthYear) {
        scrollTo(joinPage.getBirthYearInput());
        joinPage.getBirthYearInput().sendKeys(birthYear);
    }

    public void setLoginPassword(String password) {
        scrollTo(joinPage.getPasswordInput());
        joinPage.getPasswordInput().sendKeys(password);
    }

    public void clickJoinAsos() {
        scrollTo(joinPage.getJoinButton());
        joinPage.getJoinButton().click();
    }

    public boolean checkRegistrationMessageBox() {
        WebElement messageBox = joinPage.getRegistrationMessageBox();
        return messageBox.isDisplayed();
    }

    public boolean checkInvalidEmailMessageBox(){
        WebElement messageBox=joinPage.getInvalidEmailMassage();
        return messageBox.isDisplayed();
    }
}
