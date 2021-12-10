package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends Page {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div//a[text()='Login']")
    private WebElement loginBtn;

    public void openLogin() {
        loginBtn.click();
    }
}
