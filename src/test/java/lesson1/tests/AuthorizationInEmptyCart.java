package lesson1.tests;

import lesson1.pages.Advertisement;
import lesson1.pages.Authorization;
import lesson1.pages.Cart;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthorizationInEmptyCart extends SeleniumBase {

    private Authorization authorization;
    private Advertisement advertisement;
    private Cart cart;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        advertisement = PageFactory.initElements(driver, Advertisement.class);
        cart = PageFactory.initElements(driver, Cart.class);
    }

    @Test
    public void authorizationInEmptyCart() {
        // Navigate site
        driver.navigate().to(SITE_URL);

        // Close advertisement
        advertisement.closeAdvertisementLayer();

        // Click on cart
        element(".right-cart-icon").click();

        // Delete item in cart
        cart.deleteAllItemsInCart();

        // Click on authorization link
        element("[ae_button_type=\"login\"]").click();

        try {
            // Enter login
            authorization.fillLoginField(Credentials.TEST_ACCOUNT_NEW_USER);

            // Enter password
            authorization.fillPasswordField(Credentials.TEST_ACCOUNT_NEW_USER);

        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        // 5. Click enter button
        element(".fm-button").click();

        // 6. Click on authorization link
        element("[ae_button_type=\"login\"]").click();
    }
}
