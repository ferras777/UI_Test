package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;
import lesson1.test.enums.Credentials;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class Authorization extends SeleniumBase {

    @FindBy(css = "#fm-login-id")
    private WebElement loginField;

    @FindBy(css = "#fm-login-password")
    private WebElement passwordField;

    @FindBy(css = ".fm-button")
    private WebElement enterButton;

    public Authorization(WebDriver driver) {
        SeleniumBase.driver = driver;
    }

    public void fillLoginField(Credentials credentials) {
        loginField.clear();
        loginField.sendKeys(credentials.LOGIN);
    }

    public void fillPasswordField(Credentials credentials) {
        passwordField.clear();
        passwordField.sendKeys(credentials.PASSWORD);
    }

    public void fromMainPage(Credentials credentials) {
        try {
            // 1. Click Enter button
            driver.findElement(By.cssSelector(".register-btn")).click();
            // 2. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 3. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 4. Enter login
            fillLoginField(Credentials.TEST_ACCOUNT_NEW_USER);
            // 5. Enter password
            fillPasswordField(Credentials.TEST_ACCOUNT_NEW_USER);
            // 6. Click submit button
            driver.findElement(By.cssSelector(".password-login")).click();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Registration not required");
        }
    }

    public void clickOnEnterButton() {
        enterButton.click();
    }
}
