package testCases;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public Logger logger;
    public Properties properties;

    @BeforeClass()
    @Parameters({"operatingSystem", "browser"})
    public void setUp(String operatingSystem, String browser) throws IOException {
        //Loading Config.properties file
        FileReader fileReader = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(fileReader);

        //Configure Logger
        logger = LogManager.getLogger(this.getClass());

        //Determine Execution environment
        String executionEnvironment = properties.getProperty("executionEnvironment", "local");
        if("remote".equals(executionEnvironment)){
            driver = initializeRemoteDriver(operatingSystem,browser);
        }else{
            driver = initializeLocalDriver(browser);
        }

        if (driver == null) {
            throw new IllegalStateException("Driver initialization failed.");
        }

        // Common driver setup
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
        logger.info("****** Test Started ******");
    }

    @AfterClass
    public void tearDown(){
        logger.info("****** Testing Completed ******");
        driver.close();
    }

    private WebDriver initializeRemoteDriver(String operatingSystem, String browser) throws IOException{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(getPlatform(operatingSystem));
        desiredCapabilities.setBrowserName(getBrowserName(browser));

        String hubUrl = properties.getProperty("hubURL");
        if (hubUrl == null || hubUrl.isEmpty()) {
            logger.error("Hub URL is not specified");
            return null;
        }

        return new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);
    }

    private WebDriver initializeLocalDriver(String browser){
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> {
                logger.warn("Unsupported browser specified, defaulting to Chrome");
                yield new ChromeDriver();
            }
        };

    }

    private Platform getPlatform(String operatingSystem){
        return switch (operatingSystem.toLowerCase()) {
            case "windows" -> Platform.WIN11;
            case "mac" -> Platform.MAC;
            default -> {
                logger.error("Unsupported platform: " + operatingSystem);
                throw new IllegalArgumentException("Unsupported platform: " + operatingSystem);
            }
        };
    }

    private String getBrowserName(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome" ->  "chrome";
            case "edge" ->  "edge";
            case "firefox" ->  "firefox";
            default -> {
                logger.error("Unsupported browser type: " + browser);
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
            }
        };
    }


}
