package lesson1.negative;

import lesson1.pages.Authorization;
import lesson1.test.Credentials;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase4 extends SeleniumBase {
    private Authorization authorization;

    @BeforeMethod
    public void beforeMethod() {
        authorization = PageFactory.initElements(driver, Authorization.class);
    }

    @Test
    public void testCase4() {
        // Navigate aliexpress
        driver.navigate().to(SITE_URL);

        // Login in acc
        authorization.fromMainPage(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();

        // Click on profile link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[5]/div[1]/" +
                "div[2]/div/div[4]/div[2]/div[3]/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div/div[4]" +
                "/div[2]/div[3]/ul/li[1]/a")).click();

        // Click on link
        driver.findElement(By.linkText("Улучшить перевод")).click();

        assertEquals(driver.getCurrentUrl(), "https://aliexpress.ru/home.htm");
    }
}
