package lesson1.negative;

import lesson1.pages.Advertisement;
import lesson1.pages.Authorization;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase10 extends SeleniumBase {
    private Authorization authorization;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
    }

    //TODO java code convention

    @Test
    public void testCase10() {
        // Navigate site
        driver.navigate().to(SITE_URL);

        // Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // Enter in profile
        driver.findElement(By.cssSelector(".aliexpress-icon.i-aliexpress-icon")).click();

        // Click on survey button
        driver.findElement(By.cssSelector(".ui-fixed-panel-unit.ui-fixed-panel-survey")).click();

        // Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        // Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // Click button send
        driver.findElement(By.cssSelector(".ui-button")).click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // If it passed, bug still not fixed. Negative test?
        assertEquals(actual, expected);

        // Closed second tab
        driver.close();

        // Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
