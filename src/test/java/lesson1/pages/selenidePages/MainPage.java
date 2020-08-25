package lesson1.pages.selenidePages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public void clickOnCategoriesFolders() {
        $(".categories-content-title > span:first-child").click();
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
