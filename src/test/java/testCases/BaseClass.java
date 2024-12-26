package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public Logger logger;

    @BeforeClass
    public void setUp(){

        //logger
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
