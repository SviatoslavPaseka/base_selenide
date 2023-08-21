import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textInput = $(By.id("topsearch-text"));
    private final SelenideElement searchButton = $x("//input[@value='Go']");


    public MainPage(String url) {
        Selenide.open(url);
    }


    /**
     * Doing search articles and click enter button
     * @param searchString - searching string
     */
    public SearchPage searchProduct(String searchString){
        textInput.sendKeys(searchString);
        textInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

//    public SearchPage clickSearchButton(){
//        textInput.click();
//        searchButton.click();
//        return new SearchPage();
//    }
}