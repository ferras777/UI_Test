package lesson1.tests.selenide;

import lesson1.pages.selenidePages.MainPage;
import lesson1.pages.selenidePages.ProductPage;
import lesson1.pages.selenidePages.SearchPage;
import lesson1.test.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class PriceFilterTest extends SelenideBase {
    SearchPage search = new SearchPage();
    ProductPage productPage = new ProductPage();
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");
        mainPage.closeAdvertisementPopUp();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @AfterMethod
    public void afterMethod() {
        closeWindow();
        switchTo().window(0);
        closeWindow();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testPriceFilter() {
        int minPrice = 1000;
        int maxPrice = 1500;
        int productPrice;
        boolean priceCheck;

        mainPage.closeAdvertisementPopUp();

        search.searchProduct("перчатки");

        search.setMinAndMaxPriceOfProduct(minPrice, maxPrice);

        search.clickOnRandomTitleProduct();

        //Switch to another tab
        switchTo().window(1);

        //Get product price
        productPrice = productPage.getProductPrice();

        // Check if product price in range min and max values
        priceCheck = ((minPrice - 1 <= productPrice) && (productPrice <= maxPrice + 1));
        assertTrue(priceCheck);
    }
}
