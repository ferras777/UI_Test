package lesson1.tests.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.selenidePages.MainPage;
import test.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;


// TODO: refactor

public class AdvertisementBannersTest extends SelenideBase {
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");

    }

    @AfterMethod
    public void afterMethod() {
        closeWindow();
    }

    @Test
    public void testAdvertisementBanners() {
        mainPage.closeAdvertisementPopUp();
        // For each banner, after click, checks if it's have class current
        for (SelenideElement banner : mainPage.getBannersCollection()) {
            banner.click();
            assertTrue(banner.is(Condition.cssClass("current")));
        }
    }
}
