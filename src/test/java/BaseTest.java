import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

abstract public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public void setup(){
        WebDriverManager.chromedriver().setup();
        LOGGER.info("Installing a chrome driver");
        Configuration.browser = "chrome";
        LOGGER.info("Setting conf browser: chrome");
        Configuration.webdriverLogsEnabled = true;
        LOGGER.info("Setting conf webdriverLogsEnabled: true");
        Configuration.browserSize = "3024x1964";
        LOGGER.info("Setting conf browserSize: 3024x1964");
        Configuration.headless = false;
        LOGGER.info(String.format("Setting conf headless mode: %s", String.valueOf(Configuration.headless)));
        Configuration.pageLoadTimeout = 80000L;
        LOGGER.info("Setting conf pageLoadTimeout: 40 seconds");
        Configuration.timeout = 40000L;
        LOGGER.info("Setting conf timeout: 40 seconds");
    }

    @BeforeClass
    public void init(){
        LOGGER.info("Start to setup driver");
        setup();
    }

    @AfterClass
    public void teardown(){
        LOGGER.info("tear down driver (closeWebDriver)");
        Selenide.closeWebDriver();
    }
}