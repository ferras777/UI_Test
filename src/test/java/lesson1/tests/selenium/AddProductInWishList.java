package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Authorization;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddProductInWishList extends SeleniumBase {
    private Authorization authorization;


    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
    }

    @Test
    public void addProductInWishList() {
        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Scroll down to load products
        waitVisibilityOfElement(".android-link");
        WebElement footer = driver.findElement(By.cssSelector(".android-link"));

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);", footer);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        // Click on product
        element("[data-role=\"item-box\"]:first-child").click();

        // Get title of product
        String expectedTitleOfProduct = element(".product-title-text").getText();

        // Close cookies banner
        try {
            element("#cookies-banner__container__close-btn").click();
        } catch (TimeoutException e) {
            System.out.println("No cookies banner");
        }

        // Click button add to wishlist
        element(".add-wishlist").click();

        // Navigate to wishlist
        driver.navigate().to("https://my.aliexpress.ru/wishlist/wish_list_product_list.htm");

        // Refresh page for load products
        driver.navigate().refresh();

        // Title of last added product
        String actualTitleOfProduct = element("li:nth-child(1) > div.detail > h3 > a").getText();

        assertEquals(actualTitleOfProduct, expectedTitleOfProduct);
    }
}