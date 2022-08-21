import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {
    private final SelenideElement textBoxInput = $x("//a[@data-hveid = 'CAEQAw']");

    public String getPageTitle() {
        return Selenide.title();
    }

    public void clickImageTab() {
        textBoxInput.click();
    }

}
