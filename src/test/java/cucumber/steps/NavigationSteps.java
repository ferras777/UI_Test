package cucumber.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    @Given("^I am on \"Home Page\"$")
    public void iAmOnHomePage() {
        open("https://aliexpress.com");
    }
}
