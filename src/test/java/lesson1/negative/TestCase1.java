package lesson1.negative;

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

import static org.testng.Assert.*;

public class TestCase1 extends SeleniumBase {
    private Authorization authorization;
    private Tabs tabs;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        tabs = PageFactory.initElements(driver, Tabs.class);
    }

    //TODO change naming
    //TODO use only css-selectors

    @Test
    public void testCase1() {

        // Navigate site
        driver.navigate().to(SITE_URL);

        // Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Enter messages
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-icon.i-message-icon")));
        driver.findElement(By.cssSelector(".message-icon.i-message-icon")).click();

        // Enter messages history (can't use css)
        driver.findElement(By.linkText("История сообщений")).click();

        // Switch to second tab
        tabs.switchToTab(1);

        // Enter page number 9999.
        driver.findElement(By.cssSelector("[data-role=\"input\"]")).sendKeys("9999");

        // Submit page number
        driver.findElement(By.cssSelector(".ui-button.ui-button-normal.ui-button-small")).click();

        String actualResult = driver.findElement(By.cssSelector(".ui-pagination-active")).getText();
        String expectedResult = "9999";

        // If it passed, bug fixed.
        assertNotEquals(actualResult, expectedResult);

        // Closed second tab
        driver.close();

        // Switch to first tab
        tabs.switchToTab(0);
    }
}
