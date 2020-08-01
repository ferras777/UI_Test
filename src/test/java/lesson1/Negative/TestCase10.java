package lesson1.Negative;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase10 {
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
    public void testCase10() {

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

        // 3. Try enter in acc
        try {
            // 1. Click Enter button
            driver.findElement(By.linkText("Войти")).click();
            // 2. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 3. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 4. Enter login
//            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys(login);
            // 5. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(password);
            // 6. Click submit button
            driver.findElement(By.className("password-login")).click();
        }
        catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 4. Switch to main page
        driver.switchTo().defaultContent();

        // 5. Enter in profile
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/" +
                "div[2]/div/div[4]/div[2]/div[3]/ul/li[1]/a")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // 6. Clcik on survey button
        driver.findElement(By.cssSelector(".ui-fixed-panel-unit.ui-fixed-panel-survey")).click();

        // 7. Get array of tabs
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

        // 8. Switch to second tab
        driver.switchTo().window(tabs2.get(1));

        // 9. Click button send
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/form/div[4]/button")).click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // 10. If it passed, bug still not fixed. Negative test?
        assertEquals(actual, expected);

        // 11. Closed second tab
        driver.close();

        // 12. Switch to first tab
        driver.switchTo().window(tabs2.get(0));
    }
}
