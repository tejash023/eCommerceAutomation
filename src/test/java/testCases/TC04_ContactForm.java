package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.IndexPage;

public class TC04_ContactForm extends BaseClass{

    @Test
    public void contactUsForm(){
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(driver.getTitle().contains(IndexPage.expectedTitle), "Index Page title is incorrect.");
        indexPage.contactUsLink();

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
        Assert.assertTrue(driver.getTitle().contains(IndexPage.expectedTitle), "Failed to navigate back to Index Page.");
    }
}
