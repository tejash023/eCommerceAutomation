package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Login Text
    @FindBy(xpath = "//*[@class='login-form']/h2[contains(text(),'Login to your account')]")
    WebElement loginMessage;

    //Login Email Address
    @FindBy(xpath = "//input[@data-qa='login-email']" )
    WebElement textLoginEmail;

    //Login Password
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement textLoginPassword;

    //Login Button
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;

    //Signup Text
    @FindBy(xpath = "//*[@class='signup-form']/h2[contains(text(),'New User Signup!')]")
    WebElement signUpMessage;

    //Signup Name
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement textSignUpName;

    //Signup Email
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement textSignUpEmail;

    //SignUp Button
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;

    public boolean isLoginMessageDisplayed(){
        try{
            return loginMessage.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void setLoginEmail(String email){
        textLoginEmail.sendKeys(email);
    }

    public void setLoginPassword(String password){
        textLoginPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean isSignUpMessageDisplayed(){
        try{
            return signUpMessage.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    public void setTextSignUpName(String name){
        textSignUpName.sendKeys(name);
    }

    public void setTextSignUpEmail(String email){
        textSignUpEmail.sendKeys(email);
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }
}
