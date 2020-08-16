package lesson1.positive;

import lesson1.pages.Advertisement;
import lesson1.pages.Authorization;
import lesson1.pages.Tabs;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase9 extends SeleniumBase {
    private Tabs tabs;

    @BeforeMethod
    public void beforeMethod() {
        tabs = PageFactory.initElements(driver, Tabs.class);
    }

    @Test
    public void testcase9() {

        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Click on link app
        element(".ng-item.ng-mobile").click();

        // Click on Google play button
        element("a.android-link").click();

        // Switch to new tab
        tabs.switchToTab(1);

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        tabs.switchToTab(0);
    }
}
