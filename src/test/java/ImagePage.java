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
    private final ElementsCollection imgCollection = $$x("/html/body/div[2]/c-wiz/div[3]/div[1]/div/div/div/div[1]/div[1]/span/div[1]/div[1]/div[1]/a[1]/div/img");
    private final SelenideElement sidebarImg = $x("/html/body/div[2]/c-wiz/div[3]/div[2]/div[3]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img");

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
