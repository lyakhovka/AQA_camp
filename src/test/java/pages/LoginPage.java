package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import providers.data.ConfProperties;

public class LoginPage extends Page {

    @FindBy(xpath = ".//h1[text()='Log In']")
    WebElement header;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {

        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText().equals(ConfProperties.getProperty("LoginPageHeader"))
                && driver.getTitle().equalsIgnoreCase(ConfProperties.getProperty("LoginPageHeader"));
    }
}
