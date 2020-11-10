package pages.seleniumPages;

import test.SeleniumBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends SeleniumBase {

    @FindBy(css = ".sku-property-item:first-child")
    private WebElement firstProperty;

    @FindBy(css = ".next-btn.next-large.next-btn-primary.addcart")
    private WebElement addToCartButton;

    @FindBy(css = ".product-title-text")
    private WebElement productTitle;

    @FindBy(css = ".add-wishlist")
    private WebElement addToWishlistButton;

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void addToWishlist() {
        addToWishlistButton.click();
    }

    public void selectFirstProperty() {
        firstProperty.click();
    }

    public void closeCookiesBanner() {
        try {
            driver.findElement(By.cssSelector("#cookies-banner__container__close-btn")).click();
        } catch (TimeoutException | NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("No cookies banner");
        }
    }
}
