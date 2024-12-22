package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class TC03_NegativeLoginTest extends  BaseClass{

    @Test
    public void negativeLoginTest(){

        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(indexPage.isPageTitleCorrect(), "Homepage did not load");
        indexPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginEmail("teeeja@mail.net");
        loginPage.setLoginPassword("1234");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFailMessageDisplayed(), "Login failed message not displayed");


    }
}
