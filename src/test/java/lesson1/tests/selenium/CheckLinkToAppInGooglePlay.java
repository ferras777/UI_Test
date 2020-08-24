package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.MainPage;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson1.pages.seleniumPages.Utils.switchToTab;
import static lesson1.test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class CheckLinkToAppInGooglePlay extends SeleniumBase {
    private MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void checkLinkToAppInGooglePlay() {

        // Navigate aliexpress
        driver.navigate().to(SITE.url);

        // Click on link app
        mainPage.appStores.click();

        // Click on Google play button
        mainPage.googlePlayButton.click();

        // Switch to new tab
        switchToTab(1);

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        switchToTab(0);
    }
}
