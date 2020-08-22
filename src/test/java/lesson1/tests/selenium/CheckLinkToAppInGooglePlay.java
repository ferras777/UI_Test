package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Utils;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckLinkToAppInGooglePlay extends SeleniumBase {
    private Utils utils;

    @BeforeMethod
    public void beforeMethod() {
        utils = PageFactory.initElements(driver, Utils.class);
    }

    @Test
    public void checkLinkToAppInGooglePlay() {

        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Click on link app
        element(".ng-item.ng-mobile").click();

        // Click on Google play button
        element("a.android-link").click();

        // Switch to new tab
        utils.switchToTab(1);

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        utils.switchToTab(0);
    }
}
