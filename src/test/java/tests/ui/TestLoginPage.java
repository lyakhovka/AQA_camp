//Please, ignore this class. It is out or 'config' homework scope.
//Please, ignore this class. It is out of 'ApiClient' homework scope.

package tests.ui;

import config.Config;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.LoginPage;
import testSuits.categories.UITests;

import java.time.Duration;

public class TestLoginPage {


    public static LandingPage landingPage;
    public static LoginPage loginPage;


    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", Config.getInstance().getRegisteredValue("CHROMEDRIVER").toString());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(Config.getInstance().getRegisteredValue("SIRIUSURL").toString());

        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Category(UITests.class)
    @Test
    public void test_LoginPage_is_opened_from_LandingPage() {
        landingPage.openLoginPage();
        Assert.assertTrue(loginPage.isOpened());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
