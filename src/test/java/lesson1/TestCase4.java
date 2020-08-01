package lesson1;

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

import static org.testng.Assert.assertEquals;

public class TestCase4 {
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
    public void testCase4() {
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
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/" +
                "div[2]/div/div[4]/div[2]/div[3]/ul/li[1]/a")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.linkText("Улучшить перевод")).click();
        assertEquals(driver.getCurrentUrl(), "https://aliexpress.ru/home.htm");
    }
}
