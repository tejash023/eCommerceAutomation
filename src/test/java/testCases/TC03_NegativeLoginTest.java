package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class TC03_NegativeLoginTest extends  BaseClass{

    @Test(groups = "Master")
    public void negativeLoginTest(){
        try{
            IndexPage indexPage = new IndexPage(driver);
            Assert.assertTrue(indexPage.isPageTitleCorrect(), "Homepage did not load");
            indexPage.clickLoginLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setLoginEmail("teeeja@mail.net");
            loginPage.setLoginPassword("1234");
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.isLoginFailMessageDisplayed(), "Login failed message not displayed");
        } catch (Exception e) {
            logger.error("TC03 - User Login Negative Test Failed");
            Assert.fail("User login - Negative Test Failed!!");
        }

    }
}
