package lesson1.negative;

import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class TestCase5 extends SeleniumBase {

    @Test
    public void testcase5() {
        // 1. Navigate site
        driver.navigate().to(SITE_URL);

        // 2. Close advertisement
        closeAdvertisement();

        // 3. Click on cart
        driver.findElement(By.className("right-cart-icon")).click();

        // 4. Click on authorization link
        driver.findElement(By.linkText("авторизуйтесь")).click();

        try {
            // 1. Enter login
            driver.findElement(By.id("fm-login-id")).clear();
            driver.findElement(By.id("fm-login-id")).sendKeys(Credentials.TEST_ACCOUNT_NEW_USER.LOGIN);

            // 2. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(Credentials.TEST_ACCOUNT_NEW_USER.PASSWORD);

        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        // 5. Click enter button
        driver.findElement(By.className("fm-button")).click();

        // 6. Click on authorization link
        driver.findElement(By.linkText("авторизуйтесь")).click();
    }
}
