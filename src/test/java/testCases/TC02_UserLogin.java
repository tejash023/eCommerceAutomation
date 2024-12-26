package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class TC02_UserLogin extends BaseClass{

    @Test(groups = {"Master", "Regression"})
    public void accountLoginTest(){
        logger.info("********** Started TC02 User Login Test **********");
        try{
            IndexPage indexPage = new IndexPage(driver);
            Assert.assertTrue(indexPage.isPageTitleCorrect(),"Home Page did not load: Actual - " + driver.getTitle() + " Expected - " + IndexPage.expectedTitle);
            indexPage.clickLoginLink();
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertEquals(loginPage.isLoginMessageDisplayed(),true);
            loginPage.setLoginEmail("tejash@bell.ca");
            loginPage.setLoginPassword("12345678");
            loginPage.clickLoginButton();
            Assert.assertEquals(indexPage.isLoggedInUsernamePresent(), true, "Logged in username not displayed");

        } catch (Exception e) {
            logger.error("TC02 - User Login - Failed");
            Assert.fail("TC02 User Login Failed");
        }
        logger.info("********** Finished TC02 User Login Test **********");

    }
}
