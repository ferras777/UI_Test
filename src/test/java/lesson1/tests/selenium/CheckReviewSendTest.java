package lesson1.tests.selenium;

import lesson1.pages.seleniumPages.Advertisement;
import lesson1.pages.seleniumPages.MainPage;
import lesson1.pages.seleniumPages.Profile;
import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static lesson1.pages.seleniumPages.Utils.switchToTab;
import static org.testng.Assert.assertEquals;

public class CheckReviewSendTest extends SeleniumBase {
    private Advertisement advertisement;
    private MainPage mainPage;
    private Profile profile;

    @BeforeMethod
    public void beforeMethod() {
        advertisement = PageFactory.initElements(driver, Advertisement.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        profile = PageFactory.initElements(driver, Profile.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Closed second tab
        driver.close();

        // Switch to first tab
        switchToTab(0);

        driver.close();
    }

    @Test
    public void checkReviewSend() throws InterruptedException {
        // Navigate site
        driver.navigate().to(SITE_URL);

        // Close advertisement
        advertisement.closeAdvertisementLayer();

        // Enter in accounts\
        mainPage.authorization(Credentials.TEST_ACCOUNT_NEW_USER);

        // Switch to main page
        driver.switchTo().defaultContent();
        sleep(2000);

        // Enter in profile
        mainPage.profileButton.click();

        // Click on survey button
        profile.surveyButton.click();

        // Switch to second tab
        switchToTab(1);

        // Click button send
        profile.surveySubmitButton.click();

        String actual = driver.findElement(By.tagName("pre")).getText();
        String expected = "{\"ec\":8,\"em\":\"forbidden\",\"data\":{}}";

        // Checks actual and expected
        assertEquals(actual, expected);
    }
}
