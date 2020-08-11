package lesson1.pages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends SeleniumBase {

    @FindBy(css = "#search-key")
    private WebElement searchField;

    @FindBy(css = ".search-button")
    private WebElement searchButton;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public void fillSearchField(String value) {
        searchField.sendKeys(value);
    }

    public void clickSearchButton() { searchButton.click();}
}
