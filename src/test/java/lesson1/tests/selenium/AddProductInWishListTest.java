package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.MainPage;
import lesson1.pages.seleniumPages.ProductCard;
import lesson1.pages.seleniumPages.Wishlist;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson1.test.enums.Urls.SITE;
import static lesson1.test.enums.Urls.WISHLIST;
import static org.testng.Assert.assertEquals;

public class AddProductInWishListTest extends SeleniumBase {
    private MainPage mainPage;
    private ProductCard productCard;
    private Wishlist wishlist;


    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        productCard = PageFactory.initElements(driver, ProductCard.class);
        wishlist = PageFactory.initElements(driver, Wishlist.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void addProductInWishList() {
        // Navigate aliexpress
        driver.navigate().to(SITE.url);

        // Try enter in acc
        mainPage.authorization(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Scroll down to load products
        mainPage.scrollDownToLoadProducts();

        // Click on product
        mainPage.clickOnFirstProduct();

        // Get title of product
        String expectedTitleOfProduct = productCard.getProductTitle();

        // Close cookies banner
        productCard.closeCookiesBanner();

        // Click button add to wishlist
        productCard.addToWishlist();

        // Navigate to wishlist
        driver.navigate().to(WISHLIST.url);

        // Refresh page for load products
        driver.navigate().refresh();

        // Title of last added product
        String actualTitleOfProduct = wishlist.getLastAddedProductTitle();

        assertEquals(actualTitleOfProduct, expectedTitleOfProduct);
    }
}