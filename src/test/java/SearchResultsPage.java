import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {
    private final SelenideElement textBoxInput = $x("/html/body/div[7]/div/div[4]/div/div[1]/div/div[1]/div/div[2]/a");

    public String getTitlePage() {
        return Selenide.title();
    }

    public void clickImageTab() {
        textBoxInput.click();
    }

}
