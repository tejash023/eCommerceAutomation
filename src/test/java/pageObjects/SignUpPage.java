package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    //Title
    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderTitleRadioButton;

    //Name - NA
    //Email - NA

    //Password
    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement textSignUpPassword;

    //Date of Birth

    //Days
    @FindBy(xpath = "//select[@data-qa='days']")
    WebElement selectDay;

    //Month
    @FindBy(xpath = "//select[@data-qa='months']")
    WebElement selectMonth;

    //Year
    @FindBy(xpath = "//select[@data-qa='years']")
    WebElement selectYear;

    //Newsletters Checkbox
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletterLink;

    //Offers Checkbox
    @FindBy(xpath = "//input[@id='optin']")
    WebElement specialOfferLink;

    // *Delivery First Name
    @FindBy(xpath = "//input[@data-qa='first_name']")
    WebElement textFirstName;

    // *Delivery Last Name
    @FindBy(xpath = "//input[@data-qa='last_name']")
    WebElement textLastName;

    // Company
    @FindBy(xpath = "//input[@data-qa='company']")
    WebElement textCompany;

    // *Address
    @FindBy(xpath = "//input[@data-qa='address']")
    WebElement textAddress;

    // Address2
    @FindBy(xpath = "//input[@data-qa='address2']")
    WebElement textAddress2;

    // *Country
    @FindBy(xpath = "//select[@data-qa='country']")
    WebElement selectCountry;

    // *State
    @FindBy(xpath = "//input[@data-qa='state']")
    WebElement textState;

    @FindBy(xpath = "//input[@data-qa='city']")
    WebElement textCity;

    // *Zipcode
    @FindBy(xpath = "//input[@data-qa='zipcode']")
    WebElement zipCode;

    // *Mobile Number
    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    WebElement mobileNumber;

    //Create Account Button
    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;


    public void setGenderTitle(){
        genderTitleRadioButton.click();
    }

    public void setPassword(String password){
        textSignUpPassword.sendKeys(password);
    }

    public void setBirthDay(String dayOfBirth){
        Select birthDate = new Select(selectDay);
        birthDate.selectByValue(dayOfBirth);
    }

    public void setBirthMonth(int monthOfBirth){
        Select birthMonth = new Select(selectMonth);
        birthMonth.selectByIndex(monthOfBirth);
    }

    public void setBirthYear(String yearOfBirth){
        Select yearMonth = new Select(selectYear);
        yearMonth.selectByValue(yearOfBirth);
    }

    public void selectNewsLetters(){
        newsletterLink.click();
    }

    public void selectSpecialOffers(){
        specialOfferLink.click();
    }

    public void setFirstName(String firstName){
        textFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        textLastName.sendKeys(lastName);
    }

    public void setCompany(String company){
        textCompany.sendKeys(company);
    }

    public void setAddress(String address){
        textAddress.sendKeys(address);
    }

    public void setAddress2(String address2){
        textAddress2.sendKeys(address2);
    }

    public void setCountry(String country){
        Select countryName = new Select(selectCountry);
        countryName.selectByValue(country);
    }

    public void setState(String state){
        textState.sendKeys(state);
    }

    public void setCity(String city){
        textCity.sendKeys(city);
    }

    public void setZipCode(String zipcode){
        zipCode.sendKeys(zipcode);
    }

    public void setMobileNumber(String mobilenumber){
        mobileNumber.sendKeys(mobilenumber);
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

}
