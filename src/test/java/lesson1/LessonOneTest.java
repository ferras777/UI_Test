package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

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

        // 1. Navigate aliexpress
        driver.navigate().to("https://aliexpress.ru/");
        driver.findElement(By.cssSelector(".close-layer")).click();
        driver.findElement(By.cssSelector("#search-key")).click();
        driver.findElement(By.cssSelector("#search-key")).sendKeys("nexus 5");
        driver.findElement(By.cssSelector(".search-button")).click();
        softAssert.assertEquals(driver.findElement(By.id("search-key")).getText(), "nexus 5");

    }
}
