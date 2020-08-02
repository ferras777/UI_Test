package lesson1.Positive;

import lesson1.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase6 extends TestBase {

    @Test
    public void testcase6() {
        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Click on cart
        driver.findElement(By.className("right-cart-icon")).click();

        // 4. Get title of page
        String actual = driver.getTitle();

        // 5. Expected
        String expected = "Your AliExpress shopping cart - Buy directly from China";

        assertEquals(actual, expected);
    }
}
