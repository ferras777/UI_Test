package pages.seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.SeleniumBase;

public class Messages extends SeleniumBase {

    @FindBy(css = "a[href*=\"buyerMsgList.htm\"]")
    public WebElement messageHistoryButton;
    @FindBy(css = ".ui-pagination-active")
    public WebElement activePageNumber;
    @FindBy(css = "[data-role=\"input\"]")
    private WebElement fieldPageNumber;

    public void goToPage(int number) {
        driver.findElement(By.cssSelector("[data-role=\"input\"]")).sendKeys(String.valueOf(number));
        driver.findElement(By.cssSelector(".ui-button.ui-button-normal.ui-button-small")).click();
    }
}
