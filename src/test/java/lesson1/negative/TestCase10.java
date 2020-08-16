package lesson1.negative;

import lesson1.pages.Advertisement;
import lesson1.pages.Authorization;
import lesson1.pages.Tabs;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase10 extends SeleniumBase {
    private Authorization authorization;
    private Advertisement advertisement;
    private Tabs tabs;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        advertisement = PageFactory.initElements(driver, Advertisement.class);
        tabs = PageFactory.initElements(driver, Tabs.class);
    }

    //TODO java code convention

    @Test
    public void testCase10() {
        // Navigate site
        driver.navigate().to(SITE_URL);

        // Close advertisement
        advertisement.closeAdvertisementLayer();

        // Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Enter in profile
        element(".aliexpress-icon.i-aliexpress-icon").click();

        // Click on survey button
        element(".ui-fixed-panel-unit.ui-fixed-panel-survey").click();

        // Switch to second tab
        tabs.switchToTab(1);

        // Click button send
        element(".ui-button.ui-button-primary.ui-button-medium.j-submit-survey-form").click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // If it passed, bug still not fixed.
        assertEquals(actual, expected);

        // Closed second tab
        driver.close();

        // Switch to first tab
        tabs.switchToTab(0);
    }
}
