package lesson1.Negative;

import lesson1.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase1 extends TestBase {

    //TODO change naming
    //TODO use only css-selectors

    @Test
    public void testCase1() {

        // 1. Navigate site
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Try enter in acc
        loginAcc();

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
