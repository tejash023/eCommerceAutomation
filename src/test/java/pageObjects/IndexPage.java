package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IndexPage extends BasePage {

    public static String expectedTitle = "Automation Exercise";

    public IndexPage(WebDriver driver){
        super(driver);
    }

    //Login - Signup Page
    @FindBy(xpath = "//*[contains(text(), 'Signup / Login')]")
    WebElement loginPageLink;

    //Products Page
    @FindBy(xpath = "//*[contains(text(),'Products')]")
    WebElement productPageLink;

    //Cart Page
    @FindBy(xpath = "//*[contains(text(),'Cart')]")
    WebElement cartPageLink;

    //Contact us Page
    @FindBy(xpath = "//*[contains(text(),'Contact us')]")
    WebElement contactPageLink;

    //Delete Account
    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteAccountLink;

    //Logged in Message
    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInUsernameConfirmation;

    //Test Case Page Link
    @FindBy(xpath = "//a[contains(text(), 'Test Cases'')]")
    WebElement testCasePageLink;

    public void clickLoginLink(){
        loginPageLink.click();
    }

    public void clickProductsLink(){
        productPageLink.click();
    }

    public void clickCartLink(){
        cartPageLink.click();
    }

    public void clickContactUsLink(){
        contactPageLink.click();
    }

    public void clickDeleteAccount(){
        deleteAccountLink.click();
    }

    public boolean isLoggedInUsernamePresent(){
        try{
            return loggedInUsernameConfirmation.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isPageTitleCorrect(){
        String actualTitle = driver.getTitle();
        return actualTitle.contains(expectedTitle);
    }

    public void clickTestCasePageLink(){
        testCasePageLink.click();
    }
}
