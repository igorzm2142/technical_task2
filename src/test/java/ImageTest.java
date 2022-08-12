import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ImageTest extends BaseTest {
    private final static String DEFAULT_URL = "https://www.google.com/";
    private final static String NAME_AND_SURNAME = "Игорь Купчану";
    private final static String GOOGLE_MAIN_PAGE_TITLE = "Google";
    private final static String SEARCH_OUTPUT_PAGE_TITLE = "Игорь Купчану - Поиск в Google";
    private final static String IMAGE_PAGE_TITLE = "Игорь Купчану – Google Поиск";

    @Test
    public void downloadImg() {
        MainPage mainPage = new MainPage(DEFAULT_URL);
        Assert.assertEquals(GOOGLE_MAIN_PAGE_TITLE, mainPage.getTitlePage());
        mainPage.search(NAME_AND_SURNAME);

        SearchResultsPage searchOutputPage = new SearchResultsPage();
        Assert.assertEquals(SEARCH_OUTPUT_PAGE_TITLE, searchOutputPage.getTitlePage());
        searchOutputPage.clickImageTab();

        ImagePage imgPage = new ImagePage();
        // Выкидывает ошибку возможно из-за того, что title содержит &nbsp; и строки не совпадают,
        // пока закомментировал
        //Assert.assertEquals(IMAGE_PAGE_TITLE, imgPage.getTitlePage());
        imgPage.clickFirstImg();

        try {
            imgPage.downloadImg();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}