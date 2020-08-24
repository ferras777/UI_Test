package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.MainPage;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson1.test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class CheckLinkPhonesAndAccessories extends SeleniumBase {
    private MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }


    @Test
    public void checkLinkPhonesAndAccessories() {

        // Navigate aliexpress
        driver.navigate().to(SITE.url);

        // Click on link Phones and accessories
        mainPage.clickOnCellphonesCategoryLink();

        // Expected title
        String expectedTitle = "Купить Мобильные телефоны и аксессуары по низкой цене в интернет магазине АлиЭкспресс";

        // Actual title
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);
    }
}
