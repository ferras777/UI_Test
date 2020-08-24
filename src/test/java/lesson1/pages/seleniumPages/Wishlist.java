package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Wishlist extends SeleniumBase {

    @FindBy(css = "li:nth-child(1) > div.detail > h3 > a")
    private WebElement lastAddedProductTitle;

    public Wishlist(WebDriver driver) {
        SeleniumBase.driver = driver;
    }

    public String getLastAddedProductTitle() {
        return lastAddedProductTitle.getText();
    }
}
