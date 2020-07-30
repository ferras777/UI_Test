package lesson1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase1 {

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
    public void testCase1() {
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

        // 3. Click Enter button
        driver.findElement(By.linkText("Войти")).click();

        // 4. Wait 5 sec for load frame
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        // 5. Switch to frame

        try {
            driver.switchTo().frame("alibaba-login-box");
        } catch (NoSuchFrameException e) {
            System.out.print("Can't find frame");
        }

        // 6. Enter login
//        driver.findElement(By.id("fm-login-id")).sendKeys(login);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys(login);

        // 7. Enter password
        driver.findElement(By.id("fm-login-password")).sendKeys(password);

        // 8. Click submit button
        driver.findElement(By.className("password-login")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Сообщения")).click();
        driver.findElement(By.linkText("История сообщений")).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]" +
                "/div/div[2]/div/div/div/div[2]/label/input")).sendKeys("9999");
        driver.findElement(By.cssSelector(".ui-button.ui-button-normal.ui-button-small")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualResult = driver.findElement(By.className("ui-pagination-active")).getText();
        String expectedResult = "9999";
        assertEquals(actualResult, expectedResult);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }
}
