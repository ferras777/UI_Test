package lesson1.pages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Tabs extends SeleniumBase {

    public Tabs(WebDriver driver) {
        this.driver = driver;
    }


    public void switchToTab(int number) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }
}
