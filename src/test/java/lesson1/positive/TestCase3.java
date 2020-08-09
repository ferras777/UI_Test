package lesson1.positive;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase3 extends SeleniumBase {

    @Test
    public void testcase3() {

        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Click on link Phones and accessories
        driver.findElement(By.linkText("Телефоны и аксессуары")).click();

        // Expected title
        String expectedTitle = "Купить Мобильные телефоны и аксессуары по низкой цене в интернет магазине АлиЭкспресс";

        // Actual title
        String actualTitle = driver.getTitle();

        // 4. Equals titles
        assertEquals(actualTitle, expectedTitle);
    }
}
