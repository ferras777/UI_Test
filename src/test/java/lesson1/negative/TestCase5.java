package lesson1.negative;

import lesson1.pages.Advertisement;
import lesson1.pages.Authorization;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 extends SeleniumBase {

    private Authorization authorization;
    private Advertisement advertisement;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
        advertisement = PageFactory.initElements(driver, Advertisement.class);
    }

    @Test
    public void testcase5() {
        // 1. Navigate site
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        advertisement.closeAdvertisementLayer();

        // 3. Click on cart
        driver.findElement(By.cssSelector(".right-cart-icon")).click();

        // 4. Click on authorization link
        driver.findElement(By.cssSelector("[ae_button_type=\"login\"]")).click();

        try {
            // 1. Enter login
            authorization.fillLoginField(Credentials.TEST_ACCOUNT_NEW_USER);

            // 2. Enter password
            authorization.fillPasswordField(Credentials.TEST_ACCOUNT_NEW_USER);

        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        // 5. Click enter button
        driver.findElement(By.cssSelector(".fm-button")).click();

        // 6. Click on authorization link
        driver.findElement(By.cssSelector("[ae_button_type=\"login\"]")).click();
    }
}
