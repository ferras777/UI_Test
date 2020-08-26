package lesson1.Positive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase9 extends TestBase {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @Test
    public void shopUrlTest() {

        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Click on link Phones and accessories
        driver.findElement(By.linkText("Приложение")).click();

        // 4. Click on Google play button
        driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/a")).click();

        // Gets array of tabs
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

        // 5. Switch to new tab
        driver.switchTo().window(newTab.get(1));

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // 4. Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        driver.switchTo().window(newTab.get(0));
    }
}