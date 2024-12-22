package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage{

    public ContactPage(WebDriver driver){
        super(driver);
    }

    //Name Field
    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement textContactName;

    //Email Field
    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement textContactEmail;

    //Subject Field
    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement textContactSubject;

    //Message Field
    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement textContactMessage;

    //File upload
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement contactFileUpload;

    //Submit Button
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement contactSubmitButton;

    //Contact Submission Confirmation
    @FindBy(xpath = "//*[contains(text(),'Success! Your details have been submitted successfully.')]")
    WebElement contactSubmitSubmissionSuccessMessage;

    //Home Button
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement contactHomeButton;

    public void setContactName(String name){
        textContactName.sendKeys(name);
    }

    public void setContactEmail(String email){
        textContactEmail.sendKeys(email);
    }

    public void setContactSubject(String subject){
        textContactSubject.sendKeys(subject);
    }

    public void setTextContactMessage(String message){
        textContactMessage.sendKeys(message);
    }

    public void setContactFileUpload(){
        contactFileUpload.sendKeys("C:\\Users\\TejashwaRajvardhan\\Downloads\\pictures\\upload.png");
    }

    public void clickContactSubmitButton(){
        wait.until(ExpectedConditions.visibilityOf(contactSubmitButton));
        contactSubmitButton.click();
    }

    public boolean isSubmitSuccessConfirmationDisplayed(){
        try{
            wait.until(ExpectedConditions.visibilityOf(contactSubmitSubmissionSuccessMessage));
            return contactSubmitSubmissionSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return  false;
        }
    }

    public void clickContactHomeButton(){
        wait.until(ExpectedConditions.visibilityOf(contactHomeButton));
        contactHomeButton.click();
    }
}
