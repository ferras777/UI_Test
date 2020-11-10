package lesson1.tests.selenium;

import pages.seleniumPages.MainPage;
import pages.seleniumPages.Messages;
import test.SeleniumBase;
import test.enums.Credentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.seleniumPages.Utils.switchToTab;
import static org.testng.Assert.assertEquals;
import static test.enums.Urls.SITE;

public class CheckPaginationInHistoryMessageTest extends SeleniumBase {
    private MainPage mainPage;
    private Messages messages;

    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        messages = PageFactory.initElements(driver, Messages.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Closed second tab
        driver.close();

        // Switch to first tab
        switchToTab(driver, 0);

        driver.close();
    }

    @Test
    public void checkPaginationInHistoryMessage() {

        // Navigate site
        driver.navigate().to(SITE.getUrl());

        // Authorization
        mainPage.authorization(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Enter messages
        mainPage.messageButton.click();

        // Enter messages history
        messages.messageHistoryButton.click();

        // Switch to second tab
        switchToTab(driver, 1);

        // Go to page number 9999.
        messages.goToPage(9999);

        String actualResult = messages.activePageNumber.getText();
        String expectedResult = "9999";

        // If it passed, bug fixed.
        assertEquals(actualResult, expectedResult);
    }
}
