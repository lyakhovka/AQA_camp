//Please, ignore this class. It is out or 'config' homework scope.
//Please, ignore this class. It is out of 'ApiClient' homework scope.

package tests.ui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.LoginPage;

public class TestLoginPage {


    public static LandingPage landingPage;
    public static LoginPage loginPage;


    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

//        System.setProperty("webdriver.chrome.driver", new ConfFromPropertiesProvider().getProperty("chromedriver"));
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get(new ConfFromPropertiesProvider().getProperty("baseUrl"));
//
//        landingPage = new LandingPage(driver);
//        loginPage = new LoginPage(driver);
    }

    @Test
    public void navigateLoginPage() {
//        landingPage.openLogin();
//        Assert.assertTrue(loginPage.isOpened());

    }

    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }

}
