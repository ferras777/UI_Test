package lesson1.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

//TODO move class to "src/main" folder
//TODO base class should be universal

public abstract class SeleniumBase {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public String SITE_URL = "https://aliexpress.ru/";


    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=src\\main\\resources\\Profiles");
        options.addArguments("--profile-directory=Profile 1");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
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
}
