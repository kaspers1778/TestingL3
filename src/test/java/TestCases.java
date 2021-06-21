import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.*;
import utils.Driver;

public class TestCases {
    private WebDriver driver;

    private void setUpSteps(){
        joinSteps = new JoinSteps();

        basicSteps = new BasicSteps();

        accountLoginSteps = new AccountLoginSteps();
    }

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Driver.setDriver(driver);
        setUpSteps();
    }
    @Steps
    JoinSteps joinSteps ;

    @Steps
    BasicSteps basicSteps ;

    @Steps
    AccountLoginSteps accountLoginSteps ;


    @Test
    public void checkRegistrationInvalidEmail(){
        basicSteps.openURL();
        basicSteps.clickOnJoin();
        joinSteps.setLoginEmail("email");
        joinSteps.setFirstName("Petro");
        joinSteps.setLastName("Balachin");
        joinSteps.setBirthYear("2000");
        joinSteps.setBirthDay("15");
        joinSteps.setBirthMonth("J");
        joinSteps.setLoginPassword("password");
        joinSteps.clickJoinAsos();
        Assert.assertTrue(joinSteps.checkInvalidEmailMessageBox());
    }

    @Test
    public void checkRegistrationInvalidPassword(){
        basicSteps.openURL();
        basicSteps.clickOnJoin();
        joinSteps.setLoginEmail("email@gmail.com");
        joinSteps.setFirstName("Petro");
        joinSteps.setLastName("Balachin");
        joinSteps.setBirthYear("2000");
        joinSteps.setBirthDay("15");
        joinSteps.setBirthMonth("J");
        joinSteps.setLoginPassword("p");
        joinSteps.clickJoinAsos();
        Assert.assertTrue(basicSteps.checkIfFilledIconDisplayed());
    }

    @Test
    public void checkSuccessfulRegistration(){
        basicSteps.openURL();
        basicSteps.clickOnJoin();
        joinSteps.setLoginEmail("email2005@gmail.com");
        joinSteps.setFirstName("Petro");
        joinSteps.setLastName("Balachin");
        joinSteps.setBirthYear("2000");
        joinSteps.setBirthDay("15");
        joinSteps.setBirthMonth("J");
        joinSteps.setLoginPassword("password2000");
        joinSteps.clickJoinAsos();
        Assert.assertTrue(joinSteps.checkRegistrationMessageBox());
    }

    @Test
    public void checkSuccessfulSignIn(){
        basicSteps.openURL();
        basicSteps.clickOnSignIn();
        accountLoginSteps.setLogin("anna_melnychuk@gmail.com");
        accountLoginSteps.setPassword("46c_JFdVhH!R3tS");
        accountLoginSteps.loginInAccount();
        Assert.assertTrue(basicSteps.checkIfFilledIconDisplayed());

    }

    @Test
    public void checkNegativeSignIn(){
        basicSteps.openURL();
        basicSteps.clickOnSignIn();
        accountLoginSteps.setLogin("email2005@gmail.com");
        accountLoginSteps.setPassword("46c_JFdVhH!R3tS");
        accountLoginSteps.loginInAccount();
        Assert.assertTrue(accountLoginSteps.messageWrongSignIn());
    }
}
