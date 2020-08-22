package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Authorization;
import lesson1.pages.seleniumPages.Utils;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckPaginationInHistoryMessage extends SeleniumBase {
    private Authorization authorization;
    private Utils utils;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        utils = PageFactory.initElements(driver, Utils.class);
    }

    @Test
    public void checkPaginationInHistoryMessage() {

        // Navigate site
        driver.navigate().to(SITE_URL);

        // Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Enter messages
        element(".message-icon.i-message-icon").click();

        // Enter messages history (can't use css)
        element("a[href*=\"buyerMsgList.htm\"]").click();

        // Switch to second tab
        utils.switchToTab(1);

        // Enter page number 9999.
        element("[data-role=\"input\"]").sendKeys("9999");

        // Submit page number
        element(".ui-button.ui-button-normal.ui-button-small").click();

        String actualResult = driver.findElement(By.cssSelector(".ui-pagination-active")).getText();
        String expectedResult = "9999";

        // If it passed, bug fixed.
        assertEquals(actualResult, expectedResult);

        // Closed second tab
        driver.close();

        // Switch to first tab
        utils.switchToTab(0);
    }
}
