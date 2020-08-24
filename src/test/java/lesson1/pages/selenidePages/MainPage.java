package lesson1.pages.selenidePages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public ElementsCollection getBannersCollection() {
        return $$(".ui-banner-slider-nav > span");
    }
}
