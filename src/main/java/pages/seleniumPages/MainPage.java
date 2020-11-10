package pages.seleniumPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test.SeleniumBase;
import test.enums.Credentials;

import java.util.concurrent.TimeUnit;

public class MainPage extends SeleniumBase {

    @FindBy(css = ".ng-item.ng-mobile")
    public WebElement appStores;

    @FindBy(css = "a.android-link")
    public WebElement googlePlayButton;

    @FindBy(css = ".message-icon.i-message-icon")
    public WebElement messageButton;

    @FindBy(css = ".aliexpress-icon.i-aliexpress-icon")
    public WebElement profileButton;

    @FindBy(css = ".categories-content-title > span:first-child")
    public WebElement categoriesFolder;

    @FindBy(css = "#fm-login-id")
    private WebElement loginField;

    @FindBy(css = "#fm-login-password")
    private WebElement passwordField;

    @FindBy(css = ".android-link")
    private WebElement androidLink;

    @FindBy(css = "[data-role=\"item-box\"]:first-child")
    private WebElement firstProduct;

    @FindBy(css = ".right-cart-icon")
    private WebElement cartButton;

    @FindBy(css = "[href*=\"cellphones-tele\"]")
    private WebElement cellphonesLink;

    public void fillLoginField(Credentials credentials) {
        loginField.clear();
        loginField.sendKeys(credentials.LOGIN);
    }

    public void fillPasswordField(Credentials credentials) {
        passwordField.clear();
        passwordField.sendKeys(credentials.PASSWORD);
    }

    public void authorization(Credentials credentials) {
        try {
            // 1. Click Enter button
            driver.findElement(By.cssSelector(".register-btn")).click();
            // 2. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 3. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 4. Enter login
            fillLoginField(credentials);
            // 5. Enter password
            fillPasswordField(credentials);
            // 6. Click submit button
            driver.findElement(By.cssSelector(".password-login")).click();

            Thread.sleep(2000);
        } catch (NoSuchElementException | ElementNotInteractableException | InterruptedException e) {
            System.out.println("Registration not required");
        }
    }

    public void scrollDownToLoadProducts() {
        WebElement footer = driver.findElement(By.cssSelector(".android-link"));

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);", footer);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    public void clickOnFirstProduct() {
        firstProduct.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnCellphonesCategoryLink() {
        cellphonesLink.click();
    }
}
