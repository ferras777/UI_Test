package lesson1.test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public abstract class SelenideBase {
    public String SITE_URL = "https://aliexpress.ru/";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = SITE_URL;
        Configuration.startMaximized = true;


        Configuration.browserCapabilities = new MutableCapabilities(profileForAuthorizationChrome());
    }

    public ChromeOptions profileForAuthorizationChrome() {
        String pathToProfiles = "--user-data-dir=src\\main\\resources\\Profiles";
        String profile = "--profile-directory=Profile 1";
        ChromeOptions options = new ChromeOptions();

        options.addArguments(pathToProfiles);
        options.addArguments(profile);

        return options;
    }
}
