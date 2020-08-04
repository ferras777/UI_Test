package lesson1.Positive;

import test.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase6 extends TestBase {

    @Test
    public void testcase6() {
        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Add text in search box
        driver.findElement(By.id("search-key")).sendKeys("кошельки кожаные");

        // 4. Click search button
        driver.findElement(By.className("search-button")).click();

        // 5. Click on product
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[2]" +
                "/ul/div[1]/li[1]/div/div[1]/div/a")).click();

        // 7. Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());

        // 8. Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // 9. Get expected title of product
        String expectedTitle = driver.findElement(By.className("product-title-text")).getText();

        // 10. Click on property
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div[7]/div/div/ul/li[1]")).click();

        // 11. Close cookies banner
        driver.findElement(By.id("cookies-banner__container__close-btn")).click();

        // 12. Add product in cart
        driver.findElement(By.cssSelector(".next-btn.next-large.next-btn-primary.addcart")).click();

        // 13. Navigate to cart
        driver.navigate().to("https://shoppingcart.aliexpress.ru/shopcart/shopcartDetail.htm");

        // 14. Get actual title of product in cart
        String actualTitle = driver.findElement(By.className("product-name-link")).getText();

        assertEquals(actualTitle, expectedTitle);

        // 12. Closed second tab
        driver.close();

        // 13. Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
