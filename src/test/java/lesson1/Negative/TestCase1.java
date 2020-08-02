package lesson1.Negative;

import lesson1.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase1 extends TestBase {

    @Test
    public void testCase1() {


        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);


        // 2. Close advertisement
        closeAdvertisement();

        // 3. Try enter in acc
        loginInAcc();

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Enter messages
        driver.findElement(By.linkText("Сообщения")).click();

        // 6. Enter messages history
        driver.findElement(By.linkText("История сообщений")).click();

        // 7. Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

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
