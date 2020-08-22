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
        int min = 1000;
        int max = 1500;
        int productPrice;
        boolean priceCheck;

        search.searchProduct("толстовки");

        search.setMinAndMaxPriceOfProduct(min, max);

        search.clickOnRandomTitleProduct();

        //Switch to another tab
        //noinspection ResultOfMethodCallIgnored
        switchTo().window(1);

        //Get product price
        productPrice = productPage.getProductPrice();

        // Check if product price in range
        priceCheck = ((min - 1 <= productPrice) && (productPrice <= max + 1));
        assertTrue(priceCheck);
    }
}
