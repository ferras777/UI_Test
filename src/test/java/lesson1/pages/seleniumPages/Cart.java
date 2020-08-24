package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends SeleniumBase {

    @FindBy(css = ".select-all-container .next-checkbox-input")
    private WebElement checkBoxAllItemsInCart;

    @FindBy(css = "[ae_button_type=\"remove\"]")
    private WebElement removeButton;

    @FindBy(css = "div.next-dialog-footer.next-align-left > button:first-child")
    private WebElement okButton;

    @FindBy(css = ".product-name-link")
    private WebElement productTitle;

    @FindBy(css = "[ae_button_type=\"login\"]")
    private WebElement authenticationLink;

    public Cart(WebDriver driver) {
        SeleniumBase.driver = driver;
    }

    public void deleteAllItemsInCart() {
        try {
            while (removeButton.isEnabled()) {
                //noinspection BusyWait
                Thread.sleep(1000);
                removeButton.click();
                okButton.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cart is empty");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void clickOnAuthorizationLink() {
        authenticationLink.click();
    }
}
