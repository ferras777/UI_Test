package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

//TODO move class to "src/main" folder
//TODO base class should be universal

public class TestBase {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public String SITE_URL = "https://aliexpress.ru/";
    public String LOGIN = "jasex11393@in4mail.net";
    public String PASSWORD = "qaz123";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=src\\main\\resources\\Profiles");
        options.addArguments("--profile-directory=Profile 1");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,30);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    public void closeAdvertisement() {
        try {
            driver.findElement(By.className("close-layer")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No advertisement");
        }
    }

    //TODO delete commented code
    //TODO change naming
    //TODO use only css-selectors
    public void loginAcc() {
        try {
            // 1. Click Enter button
            driver.findElement(By.linkText("Войти")).click();
            // 2. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 3. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 4. Enter login
            driver.findElement(By.id("fm-login-id")).sendKeys(LOGIN);
            // 5. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(PASSWORD);
            // 6. Click submit button
            driver.findElement(By.className("password-login")).click();
        }
        catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }
    }
}
