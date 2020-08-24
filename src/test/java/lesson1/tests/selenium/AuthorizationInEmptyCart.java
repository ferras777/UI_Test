package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Advertisement;
import lesson1.pages.seleniumPages.Authorization;
import lesson1.pages.seleniumPages.Cart;
import lesson1.pages.seleniumPages.MainPage;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthorizationInEmptyCart extends SeleniumBase {

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

    @Test
    public void authorizationInEmptyCart() {
        // Navigate site
        driver.navigate().to(SITE_URL);

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
