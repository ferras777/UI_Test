package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Cart;
import lesson1.pages.seleniumPages.ProductCard;
import lesson1.pages.seleniumPages.Search;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson1.pages.seleniumPages.Utils.switchToTab;
import static lesson1.test.enums.Urls.CART;
import static lesson1.test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class AddProductInCart extends SeleniumBase {
    private Search search;
    private Cart cart;
    private ProductCard productCard;


    @BeforeMethod
    public void beforeMethod() {
        search = PageFactory.initElements(driver, Search.class);
        cart = PageFactory.initElements(driver, Cart.class);
        productCard = PageFactory.initElements(driver, ProductCard.class);
    }

    @Test
    public void addProductInCart() {
        // Navigate aliexpress
        driver.navigate().to(SITE.url);

        // Add text in search box
        search.fillSearchField("кошельки кожаные");

        // Click search button
        search.clickSearchButton();

        // Click on product
        search.clickOnProduct();

        // Switch to second tab
        switchToTab(1);

        // Get expected title of product
        String expectedTitle = productCard.getProductTitle();

        // Click on property
        productCard.selectFirstProperty();

        // Add product in cart
        productCard.addToCart();

        // Navigate to cart
        driver.navigate().to(CART.url);

        // Get actual title of product in cart
        String actualTitle = cart.getProductTitle();

        assertEquals(actualTitle, expectedTitle);

        // Closed second tab
        driver.close();

        // Switch to first tab
        switchToTab(0);
    }
}
