package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends BasePage{

    public TestCasePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/h2/b")
    WebElement TestCasePageText;

    public boolean isTestCaseTextPresent(){
        try{
            return TestCasePageText.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
