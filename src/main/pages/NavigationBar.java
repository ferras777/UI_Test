package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.Credentials;

public class NavigationBar {

    @FindBy(css = "#search-key")
    private WebElement searchField;

    private WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchField() {
        searchField.click();
    }

    public void fillSearchField(Credentials value) {
        searchField.sendKeys(value.login);
    }

    public void openTab(int tabIndex) {

    }
}
