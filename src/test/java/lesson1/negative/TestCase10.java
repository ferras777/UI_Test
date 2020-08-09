package lesson1.negative;

import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase10 extends SeleniumBase {

    //TODO java code convention

    @Test
    public void testCase10() {
        // 1. Navigate site
        driver.navigate().to(SITE_URL);


        // 2. Close advertisement
        closeAdvertisement();

        // 3. Try enter in acc
        loginAcc(Credentials.TEST_ACCOUNT_NEW_USER);

        // 4. Switch to main page
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 5. Enter in profile
        driver.findElement(By.cssSelector(".aliexpress-icon.i-aliexpress-icon")).click();

        // 6. Click on survey button
        driver.findElement(By.cssSelector(".ui-fixed-panel-unit.ui-fixed-panel-survey")).click();

        // 7. Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        // 8. Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // 9. Click button send
        driver.findElement(By.cssSelector(".ui-button")).click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // 10. If it passed, bug still not fixed. Negative test?
        assertEquals(actual, expected);

        // 11. Closed second tab
        driver.close();

        // 12. Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
