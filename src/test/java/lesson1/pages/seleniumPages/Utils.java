package lesson1.pages.seleniumPages;

import lesson1.test.SeleniumBase;

import java.util.ArrayList;

public class Utils extends SeleniumBase {

    public void switchToTab(int number) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }
}
