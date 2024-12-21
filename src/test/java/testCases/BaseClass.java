package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp(){
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
