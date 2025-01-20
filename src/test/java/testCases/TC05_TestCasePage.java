package testCases;

import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.TestCasePage;

public class TC05_TestCasePage extends BaseClass{

    @Test(groups = {"Regression", "Master"})
    public void testCasesPageTest(){
        try{
            logger.info("********** Started TC05 Test Case Page Test **********");
            IndexPage indexPage = new IndexPage(driver);
            Assert.assertTrue(indexPage.isPageTitleCorrect(), "Home Page did not load");
            indexPage.clickTestCasePageLink();

            TestCasePage testCasePage = new TestCasePage(driver);
            Assert.assertEquals(testCasePage.isTestCaseTextPresent(), "TEST CASES");
        } catch (Exception e) {
            logger.error("TC05 - TC05 Test Case Page Test - Failed");
            Assert.fail("TC05 TC05 Test Case Page Test Failed");
        }
    }
}
