package lesson1.Negative;

import test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase4 extends TestBase {


    @Test
    public void testCase4() {
        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Login in acc
        loginAcc();

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Click on profile link
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[5]/div[1]/" +
                "div[2]/div/div[4]/div[2]/div[3]/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div/div[4]" +
                "/div[2]/div[3]/ul/li[1]/a")).click();

        // 6. Click on link
        driver.findElement(By.linkText("Улучшить перевод")).click();

        assertEquals(driver.getCurrentUrl(), "https://aliexpress.ru/home.htm");
    }
}
