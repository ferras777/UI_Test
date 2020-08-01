package lesson1.Negative;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestCase5 {
    SoftAssert softAssert = new SoftAssert();

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=src\\main\\resources\\Profiles");
        options.addArguments("--profile-directory=Profile 1");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void testcase5() {
        String login = "jasex11393@in4mail.net";
        String password = "qaz123";

        // 1. Navigate aliexpress
        driver.navigate().to("https://aliexpress.ru/");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        // 2. Close advertisement
        try {
            driver.findElement(By.className("close-layer")).click();
        } catch (NoSuchElementException e) {
            System.out.print("No advertisement");
        }

        // 3. Click on cart
        driver.findElement(By.className("right-cart-icon")).click();

        // 4. Click on authorization link
        driver.findElement(By.linkText("авторизуйтесь")).click();

        try {
            // 1. Enter login
            driver.findElement(By.id("fm-login-id")).sendKeys(login);

            // 2. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(password);

        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        // 8. Click enter button
        driver.findElement(By.className("fm-button")).click();

        // 9. Wait 5 sec
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 10. Click on authorization link
        driver.findElement(By.linkText("авторизуйтесь")).click();
    }
}
