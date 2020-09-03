package lesson1.tests.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import lesson1.pages.selenidePages.MainPage;
import lesson1.test.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

// TODO: remove sleeps

public class CategoryItemsRightSizeTest extends SelenideBase {
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");
        mainPage.closeAdvertisementPopUp();
    }

    @AfterMethod
    public void afterMethod() {
        closeWindow();
    }

    @Test
    public void categoryItemsRightSizeTest() {
        mainPage.closeAdvertisementPopUp();

        // Hover all categories, for load items
        for (SelenideElement element : mainPage.getMainMenuElements()) {
            element.hover();
            sleep(700);
        }
        // Checks size of menu elements
        mainPage.getMainMenuElements().shouldBe(CollectionCondition.size(13));
        mainPage.getSecondMenuBoldElements().shouldHave(CollectionCondition.size(82));
        mainPage.getSecondMenuNormalElements().shouldHave(CollectionCondition.size(588));
    }
}
