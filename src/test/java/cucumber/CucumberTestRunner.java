package cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(features = "classpath:featureFiles", glue = "classpath:steps")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod() {
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }
}