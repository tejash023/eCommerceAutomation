package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class TC02_UserLogin extends BaseClass{

    @Test
    public void accountLoginTest(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        boolean isLoginMessageDisplayed = loginPage.isLoginMessageDisplayed();
        Assert.assertEquals(isLoginMessageDisplayed,true);
        loginPage.setLoginEmail("tejash@bell.ca");
        loginPage.setLoginPassword("12345678");
        loginPage.clickLoginButton();


    }
}
