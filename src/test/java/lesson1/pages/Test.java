package lesson1.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson1.test.SeleniumBase;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class Test extends SeleniumBase {

    @FindBy(css = "#fm-login-id")
    private SelenideElement loginField;


    public static void main(String[] args) {
        open("https://aliexress.com");

        Selenide.closeWebDriver();
    }
}
