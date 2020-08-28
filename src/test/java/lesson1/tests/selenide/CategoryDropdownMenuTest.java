package lesson1.tests.selenide;

import lesson1.pages.selenidePages.MainPage;
import lesson1.pages.selenidePages.SearchPage;
import lesson1.test.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class CategoryDropdownMenuTest extends SelenideBase {
    SearchPage search = new SearchPage();
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void beforeMethod() {
        open("/");
    }

    @AfterMethod
    public void afterMethod() {
        closeWindow();
    }

    @Test
    public void testCategoryDropdownMenu() {
        mainPage.closeAdvertisementPopUp();

        search.selectCategoryOfProducts("Женская одежда");

        search.searchProduct("толстовки");

        // Checks if category is right
        assertEquals(search.getProductCategory(), "Женская одежда");
    }
}
