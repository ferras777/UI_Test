package lesson1.Positive;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase7 {
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
    public void testCase7() {
        String login = "jasex11393@in4mail.net";
        String password = "qaz123";

        // 1. Navigate aliexpress
        driver.navigate().to("https://aliexpress.ru/");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        // 2. Close advertisement
        try {
            driver.findElement(By.className("close-layer")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No advertisement");
        }

        // 3. Try enter in acc
        try {
            // 3. Click Enter button
            driver.findElement(By.linkText("Войти")).click();
            // 4. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 5. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 6. Enter login
//            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys(login);
            // 7. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(password);
            // 8. Click submit button
            driver.findElement(By.className("password-login")).click();
        } catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Scroll down to load products
        WebElement footer = driver.findElement(By.className("android-link"));

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);",footer);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 6. Click on product
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[14]/ul/li[1]")).click();

        // 7. Get title of product
        String expectedTitleOfProduct = driver.findElement(By.className("product-title-text")).getText();

        // 8. Click button add to wishlist
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.className("add-wishlist")).click();

        // 9. Navigate to wishlist
        driver.navigate().to("https://my.aliexpress.ru/wishlist/wish_list_product_list.htm");

        // 10. Title of last added product
        String actualTitleOfProduct = driver.findElement(By.xpath("/html/body/div[5]/div[2]" +
                "/div[2]/ul/li/div[1]/h3/a")).getText();

        assertEquals(actualTitleOfProduct, expectedTitleOfProduct);
    }
}