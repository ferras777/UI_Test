package lesson1.tests.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson1.pages.selenidePages.MainPage;
import lesson1.test.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class AdvertisementBannersTest extends SelenideBase {
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");
    }

    @Test
    public void testAdvertisementBanners() {
        // For each banner, after click, checks if it's have class current
        for (SelenideElement banner : mainPage.getBannersCollection()) {
            banner.click();
            assertTrue(banner.is(Condition.cssClass("current")));
        }
    }
}
