package pages.seleniumPages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Utils {

    public static void switchToTab(WebDriver driver, int number) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }
}
