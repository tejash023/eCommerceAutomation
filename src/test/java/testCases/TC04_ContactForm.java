package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.IndexPage;

public class TC04_ContactForm extends BaseClass{

    @Test(groups = "Master")
    public void contactUsForm(){
        try{
            IndexPage indexPage = new IndexPage(driver);
            Assert.assertTrue(indexPage.isPageTitleCorrect(), "Index Page title is incorrect.");
            indexPage.clickContactUsLink();

            ContactPage contactPage = new ContactPage(driver);
            contactPage.setContactName("Jon");
            contactPage.setContactEmail("jon@snow.com");
            contactPage.setContactSubject("Help!!");
            contactPage.setTextContactMessage("Need few men to guard the wall!");
            contactPage.setContactFileUpload();
            contactPage.clickContactSubmitButton();

            if (contactPage.isAlertPresent()) {
                contactPage.acceptAlert();
            } else {
                Assert.fail("Expected alert not found after form submission.");
            }

            Assert.assertEquals(contactPage.isSubmitSuccessConfirmationDisplayed(), true, "Contact Page successful submit message not displayed.");
            contactPage.clickContactHomeButton();
            Assert.assertTrue(indexPage.isPageTitleCorrect(), "Failed to navigate back to Index Page.");
        } catch (Exception e) {
            logger.error("TC04 - Contact Form Test Failed!!");
            Assert.fail("TC04 - Contact Form Test Failed");
        }

    }
}
