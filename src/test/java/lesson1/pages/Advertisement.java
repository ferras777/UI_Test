package lesson1.pages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Advertisement extends SeleniumBase {

    @FindBy(css = ".close-layer")
    private WebElement advertisementLayer;

    public Advertisement(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdvertisementLayer() {
        try {
            advertisementLayer.click();
        } catch (NoSuchElementException e) {
            System.out.println("No advertisement layer");
        }
    }


}
