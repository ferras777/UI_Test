package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Advertisement;
import lesson1.pages.seleniumPages.Authorization;
import lesson1.pages.seleniumPages.Utils;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckReviewSend extends SeleniumBase {
    private Authorization authorization;
    private Advertisement advertisement;
    private Utils utils;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        advertisement = PageFactory.initElements(driver, Advertisement.class);
        utils = PageFactory.initElements(driver, Utils.class);
    }

    @Test
    public void checkReviewSend() {
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
        utils.switchToTab(1);

        // Click button send
        element(".ui-button.ui-button-primary.ui-button-medium.j-submit-survey-form").click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // If it passed, bug still not fixed.
        assertEquals(actual, expected);

        // Closed second tab
        driver.close();

        // Switch to first tab
        utils.switchToTab(0);
    }
}
