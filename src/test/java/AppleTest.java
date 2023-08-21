import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppleTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(AppleTest.class);
    private static final String BASEURL = "https://www.gsmarena.com/";
    private static final String SEARCH_STRING = "iphone 13";
    @Test
    public void checkHref() {
        LOGGER.info(String.format("Creating MainPage instance: %s", BASEURL));
        MainPage mainPage = new MainPage(BASEURL);
        LOGGER.info(String.format("inputting %s in search field", SEARCH_STRING));
        int a =0;
        LOGGER.info("clicking on search button and create SearchPage instance");
        SearchPage searchPage = mainPage.searchProduct(SEARCH_STRING);
        LOGGER.info("getting product titles and saving it to variable result");
        String result = searchPage.getTextFromFirstGood().toLowerCase().replaceAll("\n", " ");

        LOGGER.info(String.format("result: %s", result));


        Assert.assertTrue(result.contains(SEARCH_STRING));

    }
}