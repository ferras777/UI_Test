package pages.seleniumPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile {

    @FindBy(css = ".ui-fixed-panel-unit.ui-fixed-panel-survey")
    public WebElement surveyButton;

    @FindBy(css = ".ui-button.ui-button-primary.ui-button-medium.j-submit-survey-form")
    public WebElement surveySubmitButton;
}
