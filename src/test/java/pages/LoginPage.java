//Please, ignore this class. It is out of 'config' homework scope.
//Please, ignore this class. It is out of 'ApiClient' homework scope.

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(xpath = ".//h1[text()='Log In']")
    WebElement header;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {

//        wait.until(ExpectedConditions.visibilityOf(header));
//        return header.getText().equals(new ConfFromPropertiesProvider().getProperty("LoginPageHeader"))
//                && driver.getTitle().equalsIgnoreCase(new ConfFromPropertiesProvider().getProperty("LoginPageHeader"));
        return false;
    }
}
