package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {

   WebDriver driver;
   WebDriverWait wait;

   Page (WebDriver driver){
       PageFactory.initElements(driver, this);
       this.driver = driver;

       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }

   public WebDriver getDriver(){
       return this.driver;
   }

}
