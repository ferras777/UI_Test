package lesson1.positive;

import lesson1.pages.SearchBar;
import lesson1.pages.Tabs;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase6 extends SeleniumBase {
    private Tabs tabs;
    private SearchBar searchBar;


    @BeforeMethod
    public void beforeMethod() {

        searchBar = PageFactory.initElements(driver, SearchBar.class);
        tabs = PageFactory.initElements(driver, Tabs.class);
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
        element("[product-index=\"0\"]").click();

        // Switch to second tab
        tabs.switchToTab(1);

        // Get expected title of product
        String expectedTitle = driver.findElement(By.className("product-title-text")).getText();

        // Click on property
        element(".sku-property-item:first-child").click();

        // Add product in cart
        element(".next-btn.next-large.next-btn-primary.addcart").click();

        // Navigate to cart
        driver.navigate().to("https://shoppingcart.aliexpress.ru/shopcart/shopcartDetail.htm");

        // Get actual title of product in cart
        String actualTitle = driver.findElement(By.className("product-name-link")).getText();

        assertEquals(actualTitle, expectedTitle);

        // Closed second tab
        driver.close();

        // Switch to first tab
        tabs.switchToTab(0);
    }
}
