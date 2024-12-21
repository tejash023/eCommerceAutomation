package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC01_UserRegistration extends BaseClass {

    private static final String TEST_NAME = "Tejash";
    private static final String TEST_EMAIL = "tejash@gmail.com";
    private static final String TEST_PASSWORD = "123456";
    private static final String TEST_FIRST_NAME = "Tejas";
    private static final String TEST_LAST_NAME = "Raj";
    private static final String TEST_COMPANY = "IIM";
    private static final String TEST_ADDRESS = "BTM Layout";
    private static final String TEST_COUNTRY = "Israel";
    private static final String TEST_STATE = "Bihar";
    private static final String TEST_CITY = "Patna";
    private static final String TEST_ZIP = "843212";
    private static final String TEST_MOBILE = "8877543482";
    private static final String TEST_DAY = "23";
    private static final int TEST_MONTH = 2;
    private static final String TEST_YEAR = "1998";

    @Test
    public void accountRegistrationTest() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        verifyElementDisplayed("Sign-up message", loginPage.isSignUpMessageDisplayed());
        loginPage.setTextSignUpName(TEST_NAME);
        loginPage.setTextSignUpEmail(TEST_EMAIL);
        loginPage.clickSignUpButton();

        SignUpPage signUpPage = initializeSignUpPage();
        signUpPage.clickCreateAccountButton();

        AccountCreated accountCreated = new AccountCreated(driver);
        verifyElementDisplayed("Account created confirmation message", accountCreated.isAccountCreatedMessageDisplayed());
        accountCreated.clickContinueButton();

        indexPage.deleteAccount();

        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);
        verifyElementDisplayed("Account deleted confirmation message", deleteAccountPage.isAccountDeletedMessageDisplayed());
        deleteAccountPage.clickContinueButton();
    }

    private SignUpPage initializeSignUpPage() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setGenderTitle();
        signUpPage.setPassword(TEST_PASSWORD);
        signUpPage.setBirthDay(TEST_DAY);
        signUpPage.setBirthMonth(TEST_MONTH);
        signUpPage.setBirthYear(TEST_YEAR);
        signUpPage.selectNewsLetters();
        signUpPage.selectSpecialOffers();
        signUpPage.setFirstName(TEST_FIRST_NAME);
        signUpPage.setLastName(TEST_LAST_NAME);
        signUpPage.setCompany(TEST_COMPANY);
        signUpPage.setAddress(TEST_ADDRESS);
        signUpPage.setCountry(TEST_COUNTRY);
        signUpPage.setState(TEST_STATE);
        signUpPage.setCity(TEST_CITY);
        signUpPage.setZipCode(TEST_ZIP);
        signUpPage.setMobileNumber(TEST_MOBILE);
        return signUpPage;
    }

    private void verifyElementDisplayed(String elementDescription, boolean isDisplayed) {
        Assert.assertTrue(isDisplayed, elementDescription + " not displayed!");
    }
}
