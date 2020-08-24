package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Messages extends SeleniumBase {

    @FindBy(css = "a[href*=\"buyerMsgList.htm\"]")
    public WebElement messageHistoryButton;
    @FindBy(css = ".ui-pagination-active")
    public WebElement activePageNumber;
    @FindBy(css = "[data-role=\"input\"]")
    private WebElement fieldPageNumber;

    public Messages(WebDriver driver) {
        SeleniumBase.driver = driver;
    }

    public void goToPage(int number) {
        driver.findElement(By.cssSelector("[data-role=\"input\"]")).sendKeys(String.valueOf(number));
        driver.findElement(By.cssSelector(".ui-button.ui-button-normal.ui-button-small")).click();
    }
}
