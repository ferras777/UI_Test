package cucumber.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class AssertionSteps {

    @Then("^Check that the title is ([^\"]*)")
    public void checkTitle(String title) {
        assertEquals(title, "aliexpress", "The page title is incorrect");
    }
}
