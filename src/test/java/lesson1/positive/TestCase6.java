package lesson1.positive;

import lesson1.pages.Advertisement;
import lesson1.pages.SearchBar;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCase6 extends SeleniumBase {
    private SearchBar searchBar;


    @BeforeMethod
    public void beforeMethod() {

        searchBar = PageFactory.initElements(driver, SearchBar.class);
    }

    @Test
    public void testcase6() {
        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Add text in search box
        searchBar.fillSearchField("кошельки кожаные");

        // Click search button
        searchBar.clickSearchButton();

        // Click on product
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[2]" +
                "/ul/div[1]/li[1]/div/div[1]/div/a")).click();

        // Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        // Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // Get expected title of product
        String expectedTitle = driver.findElement(By.className("product-title-text")).getText();

        // Click on property
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div[7]/div/div/ul/li[1]")).click();

        // Close cookies banner
        driver.findElement(By.id("cookies-banner__container__close-btn")).click();

        // Add product in cart
        driver.findElement(By.cssSelector(".next-btn.next-large.next-btn-primary.addcart")).click();

        // Navigate to cart
        driver.navigate().to("https://shoppingcart.aliexpress.ru/shopcart/shopcartDetail.htm");

        // Get actual title of product in cart
        String actualTitle = driver.findElement(By.className("product-name-link")).getText();

        assertEquals(actualTitle, expectedTitle);

        // Closed second tab
        driver.close();

        // Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
