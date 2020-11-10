package lesson1.tests.selenium;

import pages.seleniumPages.MainPage;
import test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.seleniumPages.Utils.switchToTab;
import static test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class CheckLinkToAppInGooglePlayTest extends SeleniumBase {
    private MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void checkLinkToAppInGooglePlay() {

        // Navigate aliexpress
        driver.navigate().to(SITE.getUrl());

        // Click on link app
        mainPage.appStores.click();

        // Click on Google play button
        mainPage.googlePlayButton.click();

        // Switch to new tab
        switchToTab(driver, 1);

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        switchToTab(driver, 0);
    }
}
