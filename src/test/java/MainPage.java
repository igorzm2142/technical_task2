import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textBoxInput = $x(
            "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public String getTitlePage() {
        return Selenide.title();
    }

    public void search(String str) {
        textBoxInput.click();
        textBoxInput.setValue(str);
        textBoxInput.sendKeys(Keys.ENTER);
    }
}