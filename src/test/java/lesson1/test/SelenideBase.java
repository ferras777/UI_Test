package lesson1.test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class SelenideBase {
    public String SITE_URL = "https://aliexpress.ru/";
    public String pathToProfile = "--user-data-dir=src\\main\\resources\\Profiles";
    public String profile = "--profile-directory=Profile 1";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = SITE_URL;
        Configuration.startMaximized = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments(pathToProfile);
        options.addArguments(profile);

        Configuration.browserCapabilities = new MutableCapabilities(options);
    }
}
