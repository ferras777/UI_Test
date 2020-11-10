package pages.seleniumPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.SeleniumBase;

public class Advertisement extends SeleniumBase {

    @FindBy(css = ".close-layer")
    private WebElement advertisementLayer;

    public void closeAdvertisementLayer() {
        try {
            advertisementLayer.click();
        } catch (NoSuchElementException e) {
            System.out.println("No advertisement layer");
        }
    }
}
