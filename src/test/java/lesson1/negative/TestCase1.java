package lesson1.negative;

import lesson1.pages.Authorization;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase1 extends SeleniumBase {
    private Authorization authorization;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
    }

    //TODO change naming
    //TODO use only css-selectors

    @Test
    public void testCase1() {

        // 1. Navigate site
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Enter messages
        driver.findElement(By.linkText("Сообщения")).click();

        // 6. Enter messages history
        driver.findElement(By.linkText("История сообщений")).click();

        // 7. Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        // 8. Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // 9. Enter page number 9999.
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]" +
                "/div/div[2]/div/div/div/div[2]/label/input")).sendKeys("9999");

        // 10. Submit page number
        driver.findElement(By.cssSelector(".ui-button.ui-button-normal.ui-button-small")).click();

        String actualResult = driver.findElement(By.className("ui-pagination-active")).getText();
        String expectedResult = "9999";

        // 11. If it passed, bug still not fixed. Negative test?
        assertEquals(actualResult, expectedResult);

        // 12. Closed second tab
        driver.close();

        // 13. Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
