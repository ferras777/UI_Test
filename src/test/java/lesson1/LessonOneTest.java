package lesson1;

import org.openqa.selenium.*;
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
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div/div[4]/div[2]/div[3]/ul/li[3]/a/span[1]")).click();
    }
}
