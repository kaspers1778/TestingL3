package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;
import utils.Driver;


public class BasicSteps {

    private WebDriver driver= Driver.getDriver();

    private BasicPage basicPage=PageFactory.initElements(driver,BasicPage.class);

    private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void openURL(){
        driver.get("https://www.asos.com/women/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(basicPage.getAccountItem()));
    }

    public void clickOnAccountItem(){
        basicPage.getAccountItem().click();
    }

    public void clickOnSignIn()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(basicPage.getAccountItem()).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(basicPage.getSignInLink()));
        basicPage.getSignInLink().click();
    }

    public void clickOnJoin()  {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(basicPage.getAccountItem()));
        Actions actions = new Actions(driver);
        actions.moveToElement(basicPage.getAccountItem()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(basicPage.getJoinLink()));
        basicPage.getJoinLink().click();
    }




    public boolean checkIfFilledIconDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(basicPage.getMyAccountIconFilled()));
        return basicPage.getMyAccountIconFilled().isDisplayed();
    }



    public void clickOnSingOutButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(basicPage.getAccountItem()).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(basicPage.getSingOutButton()));
        basicPage.getSingOutButton().click();
    }

}
