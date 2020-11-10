package pages.seleniumPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.SeleniumBase;

public class Search extends SeleniumBase {

    @FindBy(css = "#search-key")
    private WebElement searchField;

    @FindBy(css = ".search-button")
    private WebElement searchButton;

    @FindBy(css = "[product-index=\"0\"]")
    private WebElement product;

    public void fillSearchField(String value) {
        searchField.sendKeys(value);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickOnProduct() {
        product.click();
    }
}
