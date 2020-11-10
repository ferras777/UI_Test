package lesson1.tests.selenium;

import pages.seleniumPages.Advertisement;
import pages.seleniumPages.Authorization;
import pages.seleniumPages.Cart;
import pages.seleniumPages.MainPage;
import test.SeleniumBase;
import test.enums.Credentials;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static test.enums.Urls.SITE;

public class AuthorizationInEmptyCartTest extends SeleniumBase {

    private Authorization authorization;
    private Advertisement advertisement;
    private Cart cart;
    private MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        advertisement = PageFactory.initElements(driver, Advertisement.class);
        cart = PageFactory.initElements(driver, Cart.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void authorizationInEmptyCart() {
        // Navigate site
        driver.navigate().to(SITE.getUrl());

        // Close advertisement
        advertisement.closeAdvertisementLayer();

        // Click on cart
        mainPage.clickOnCartButton();

        // Delete item in cart
        cart.deleteAllItemsInCart();

        // Click on authorization link
        cart.clickOnAuthorizationLink();

        try {
            // Enter login
            authorization.fillLoginField(Credentials.TEST_ACCOUNT_NEW_USER);

            // Enter password
            authorization.fillPasswordField(Credentials.TEST_ACCOUNT_NEW_USER);

        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        // 5. Click enter button
        authorization.clickOnEnterButton();

        // 6. Click on authorization link
        cart.clickOnAuthorizationLink();
    }
}
