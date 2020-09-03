package lesson1.test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import static lesson1.test.enums.Urls.SITE;


// TODO: refactor this
public abstract class SelenideBase {

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = SITE.getUrl();
        Configuration.startMaximized = true;
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
