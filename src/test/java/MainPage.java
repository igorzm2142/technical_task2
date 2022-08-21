import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@class = 'gLFyf gsfi'][@maxlength = '2048']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public String getPageTitle() {
        return Selenide.title();
    }

    public void search(String str) {
        textBoxInput.click();
        textBoxInput.setValue(str);
        textBoxInput.sendKeys(Keys.ENTER);
    }
}
