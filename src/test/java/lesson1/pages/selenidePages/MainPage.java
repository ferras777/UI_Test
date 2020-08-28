package lesson1.pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    SelenideElement advertisementLayer = $(".close-layer");

    public void clickOnCategoriesFolders() {
        $(".categories-content-title > span:first-child").click();
    }

    public void closeAdvertisementPopUp() {
        if (advertisementLayer.isDisplayed()) {
            advertisementLayer.click();
            $(".ui-mask").shouldBe(Condition.disappear);
        }
    }

    public ElementsCollection getMainMenuElements() {
        return $$(".cl-item > dt");
    }

    public ElementsCollection getSecondMenuBoldElements() {
        return $$(".sub-cate-items > dt > a");
    }

    public ElementsCollection getSecondMenuNormalElements() {
        return $$(".sub-cate-items > dd > a");
    }

    public ElementsCollection getBannersCollection() {
        return $$(".ui-banner-slider-nav > span");
    }
}
