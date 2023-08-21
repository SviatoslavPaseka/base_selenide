import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection goodTitles = $$x("//ul/li/a/strong/span");

    /**
     * return href attribute from first article
     * @return
     */
    public String getTextFromFirstGood(){
        return goodTitles.first().getText();
    }

}