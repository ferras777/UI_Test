package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Utils extends SeleniumBase {

    public Utils(WebDriver driver) {
        SeleniumBase.driver = driver;
    }

    public static void switchToTab(int number) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }
}
