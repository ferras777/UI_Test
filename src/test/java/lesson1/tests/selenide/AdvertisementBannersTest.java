package lesson1.tests.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lesson1.test.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class AdvertisementBannersTest extends SelenideBase {

    @BeforeMethod
    public void beforeMethod() {
        open("/");
    }

    @Test
    public void testAdvertisementBanners() {
        // Get collection of banners
        ElementsCollection banners = $$(".ui-banner-slider-nav > span");

        // For each banner, after click check if it's have class current
        for (SelenideElement banner : banners) {
            banner.click();
            assertTrue(banner.is(Condition.cssClass("current")));
        }
    }
}
