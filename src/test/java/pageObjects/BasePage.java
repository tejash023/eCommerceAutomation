package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public boolean isAlertPresent() {
        try {
            Alert alert = driver.switchTo().alert(); // Attempt to switch to alert
            return true; // Alert found
        } catch (NoAlertPresentException e) {
            return false; // No alert present
        }
    }

    // Method to accept alert if present
    public void acceptAlert() {
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
    }
}