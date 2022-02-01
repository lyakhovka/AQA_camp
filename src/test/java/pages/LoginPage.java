package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

    @FindBy(xpath = ".//h1[text()='Log In']")
    WebElement header;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {

        String loginPageHeader = Config.getInstance().getRegisteredValue("LOGINPAGEHEADER").toString();
        wait.until(ExpectedConditions.visibilityOf(header));

        return header.getText().equals(loginPageHeader) && driver.getTitle().equalsIgnoreCase(loginPageHeader);
    }
}
