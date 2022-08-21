import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ImagePage {
    private final ElementsCollection imgCollection = $$x("//div[@class = 'islrc']//div[@jsaction = 'cFWHmd:s370ud;']");
    private final SelenideElement sidebarImg = $x("//div[@class = 'v4dQwb']//img[contains(@src, 'https')]");

    public String getTitlePage() {
        return Selenide.title();
    }

    public void clickFirstImg() {
        imgCollection.first().click();
    }

    public void downloadImg() throws IOException {
        String src = sidebarImg.getAttribute("src");
        if (src != null) {
            URL imageUrl = new URL(src);
            BufferedImage saveImage = ImageIO.read(imageUrl);
            ImageIO.write(saveImage, "jpg", new File("image.jpg"));
        }
    }
}
