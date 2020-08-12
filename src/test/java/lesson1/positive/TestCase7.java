package lesson1.positive;

import lesson1.pages.Authorization;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase7 extends SeleniumBase {
    private Authorization authorization;


    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
    }

    @Test
    public void testCase7() {
        // 1. Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Try enter in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Scroll down to load products
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android-link")));
        WebElement footer = driver.findElement(By.className("android-link"));

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);", footer);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        // 6. Click on product
        driver.findElement(By.cssSelector("#redesign-just-for-you > ul > " +
                "li:nth-child(1) > a > div:nth-child(1) > div")).click();

        // 7. Get title of product
        String expectedTitleOfProduct = driver.findElement(By.className("product-title-text")).getText();

        // 8. Click button add to wishlist
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add-wishlist")));
        driver.findElement(By.className("add-wishlist")).click();

        // 9. Navigate to wishlist
        driver.navigate().to("https://my.aliexpress.ru/wishlist/wish_list_product_list.htm");

        // 10. Refresh page for load products
        driver.navigate().refresh();

        // 10. Title of last added product
        String actualTitleOfProduct = driver.findElement(By.xpath("/html/body/div[5]/div[2]" +
                "/div[2]/ul/li/div[1]/h3/a")).getText();

        assertEquals(actualTitleOfProduct, expectedTitleOfProduct);
    }
}