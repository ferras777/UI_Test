package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LessonOneTest {

    SoftAssert softAssert = new SoftAssert();

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void lessonOneTest() {
        String login = "jasex11393@in4mail.net";
        String password = "qaz123";

        // 1. Navigate aliexpress
        driver.navigate().to("https://aliexpress.ru/");

        // 2. Close advertisement
        try {
            driver.findElement(By.className("close-layer")).click();
        } catch (NoSuchElementException e) {
            System.out.print("No advertisement");
        }

        // 3. Click Enter button
        driver.findElement(By.linkText("Войти")).click();

        // 4. Wait 5 sec for load frame
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 5. Switch to frame
        try {
            driver.switchTo().frame(1);
        } catch (NoSuchFrameException e) {
            System.out.print("No frame");
        }

        // 6. Enter login
        driver.findElement(By.id("fm-login-id")).sendKeys(login);

        // 7. Enter password
        driver.findElement(By.id("fm-login-password")).sendKeys(password);

        // 8. Click submit button
        driver.findElement(By.className("fm-button fm-submit password-login")).click();
    }
}
