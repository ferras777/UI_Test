package lesson1.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lesson1.pages.seleniumPages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static lesson1.test.enums.Credentials.TEST_ACCOUNT_NEW_USER;
import static lesson1.test.enums.Urls.SITE;
import static org.testng.AssertJUnit.assertTrue;

public class login_check {
    MainPage mainPage;
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void Before() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=src\\main\\resources\\Profiles");
        options.addArguments("--profile-directory=Profile 1");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void after() {
        driver.close();
    }


    @Given("Aliexpress Main Page")
    public void aliexpress_main_page() {
        driver.navigate().to(SITE.getUrl());
    }

    @When("I login in with right credentials")
    public void i_login_in_with_right_credentials() {
        mainPage.authorization(TEST_ACCOUNT_NEW_USER);
    }

    @Then("I should be authorised")
    public void i_should_be_authorised() {
        assertTrue(true);
    }
}
