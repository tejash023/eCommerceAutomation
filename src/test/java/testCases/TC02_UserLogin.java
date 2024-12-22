package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class TC02_UserLogin extends BaseClass{

    @Test
    public void accountLoginTest(){
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(indexPage.isPageTitleCorrect(),"Home Page did not load: Actual - " + driver.getTitle() + " Expected - " + IndexPage.expectedTitle);
        indexPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.isLoginMessageDisplayed(),true);
        loginPage.setLoginEmail("tejash@bell.ca");
        loginPage.setLoginPassword("12345678");
        loginPage.clickLoginButton();

        Assert.assertEquals(indexPage.isLoggedInUsernamePresent(), true, "Logged in username not displayed");


    }
}
