package lesson1.tests.selenium;

import lesson1.test.SeleniumBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckLinkPhonesAndAccessories extends SeleniumBase {

    @Test
    public void checkLinkPhonesAndAccessories() {

        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Click on link Phones and accessories
        element("[href*=\"cellphones-tele\"]").click();

        // Expected title
        String expectedTitle = "Купить Мобильные телефоны и аксессуары по низкой цене в интернет магазине АлиЭкспресс";

        // Actual title
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);
    }
}
