package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteAccountPage extends BasePage{

    public DeleteAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b[contains(text(),'Account Deleted!')]")
    WebElement accountDeletedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    public boolean isAccountDeletedMessageDisplayed(){
        try{
            return accountDeletedMessage.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickContinueButton(){
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }
}
