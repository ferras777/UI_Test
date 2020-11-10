package pages.seleniumPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.SeleniumBase;

public class Wishlist extends SeleniumBase {

    @FindBy(css = "li:nth-child(1) > div.detail > h3 > a")
    private WebElement lastAddedProductTitle;

    public String getLastAddedProductTitle() {
        return lastAddedProductTitle.getText();
    }
}
