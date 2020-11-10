package lesson1.tests.selenium;

import pages.seleniumPages.Cart;
import pages.seleniumPages.ProductCard;
import pages.seleniumPages.Search;
import test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.seleniumPages.Utils.switchToTab;
import static test.enums.Urls.CART;
import static test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class AddProductInCartTest extends SeleniumBase {
    private Search search;
    private Cart cart;
    private ProductCard productCard;


    @BeforeMethod
    public void beforeMethod() {
        search = PageFactory.initElements(driver, Search.class);
        cart = PageFactory.initElements(driver, Cart.class);
        productCard = PageFactory.initElements(driver, ProductCard.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Closed second tab
        driver.close();

        // Switch to first tab
        switchToTab(driver, 0);

        driver.close();
    }

    @Test
    public void addProductInCart() {
        // Navigate aliexpress
        driver.navigate().to(SITE.getUrl());

        // Add text in search box
        search.fillSearchField("Геометрические Роскошные брендовые кожаные кошельк");

        // Click search button
        search.clickSearchButton();

        // Click on product
        search.clickOnProduct();

        // Switch to second tab
        switchToTab(driver, 1);

        // Get expected title of product
        String expectedTitle = productCard.getProductTitle();

        // Click on property
        productCard.selectFirstProperty();

        // Add product in cart
        productCard.addToCart();

        // Navigate to cart
        driver.navigate().to(CART.getUrl());

        // Get actual title of product in cart
        String actualTitle = cart.getProductTitle();

        assertEquals(actualTitle, expectedTitle);


    }
}
