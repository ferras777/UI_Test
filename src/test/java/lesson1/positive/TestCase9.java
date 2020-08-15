package lesson1.positive;

import lesson1.pages.Advertisement;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase9 extends SeleniumBase {

    @Test
    public void testcase9() {

        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Click on link Phones and accessories
        driver.findElement(By.linkText("Приложение")).click();

        // Click on Google play button
        driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/a")).click();

        // Gets array of tabs
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

        // Switch to new tab
        driver.switchTo().window(newTab.get(1));

        String expectedTitle = "Приложения в Google Play – AliExpress онлайн магазин. Покупай со скидками!";
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);

        // Close second tab
        driver.close();

        // Switch to first tab
        driver.switchTo().window(newTab.get(0));
    }
}
