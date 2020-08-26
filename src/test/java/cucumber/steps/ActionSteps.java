package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lesson1.pages.selenidePages.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class ActionSteps {

    @When("^Click on the Categories Folders$")
    public void clickOnCategoriesFolders() {
        new MainPage().clickOnCategoriesFolders();
    }

    @And("^Close advertisement$")
    public void cliseAdvertisement() {
        $(".close-layer").click();
    }
}
