package applications.ui;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.LoginPage;
import providers.data.ConfFromPropertiesProvider;

import java.time.Duration;

public class TestLoginPage {


    public static LandingPage landingPage;
    public static LoginPage loginPage;


    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", new ConfFromPropertiesProvider().getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(new ConfFromPropertiesProvider().getProperty("baseUrl"));

        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void navigateLoginPage() {
        landingPage.openLogin();
        Assert.assertTrue(loginPage.isOpened());

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
