package lesson1.tests.selenide;

import lesson1.pages.selenidePages.ProductPage;
import lesson1.pages.selenidePages.SearchPage;
import lesson1.test.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertTrue;

public class PriceFilterTest extends SelenideBase {
    SearchPage search = new SearchPage();
    ProductPage productPage = new ProductPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");
    }

    @Test
    public void testPriceFilter() {
        int minPrice = 1000;
        int maxPrice = 1500;
        int productPrice;
        boolean priceCheck;

        search.searchProduct("перчатки");

        search.setMinAndMaxPriceOfProduct(minPrice, maxPrice);

        search.clickOnRandomTitleProduct();

        //Switch to another tab
        //noinspection ResultOfMethodCallIgnored
        switchTo().window(1);

        //Get product price
        productPrice = productPage.getProductPrice();

        // Check if product price in range min and max values
        priceCheck = ((minPrice - 1 <= productPrice) && (productPrice <= maxPrice + 1));
        assertTrue(priceCheck);
    }
}
