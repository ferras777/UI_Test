package pages.selenidePages;

import com.codeborne.selenide.ElementsCollection;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    Random random = new Random();

    public void searchProduct(String text) {
        $("#search-key").setValue(text);
        $(".search-button").click();
    }

    public void selectCategoryOfProducts(String category) {
        $(".search-cate-title").click();
        $("#search-dropdown-box").selectOptionContainingText(category);
    }

    public String getProductCategory() {
        return $$(".next-breadcrumb > div > a").get(1).getText();
    }

    public ElementsCollection productList() {
        return $$("li.list-item");
    }

    public void clickOnRandomTitleProduct() {
        productList()
                .get(random.nextInt(productList().size()))
                .hover()
                .$(".item-title")
                .click();
    }

    public void clickOnTitleProductByPosition(int position) {
        productList()
                .get(position)
                .hover()
                .$(".item-title")
                .click();
    }

    public void setMinAndMaxPriceOfProduct(int min, int max) {
        $$(".price-input.ltr > span > input").get(0).setValue(String.valueOf(min));
        $$(".price-input.ltr > span > input").get(1).setValue(String.valueOf(max));
        $(".price-input.ltr > a").click();
        sleep(2000);
    }

    public String getShipFrom() {
        return $(".next-select-values.next-input-text-field > em > span").getText();
    }

    /**
     * Select ship from.
     *
     * @param country "russia", "china"
     */
    public void setShipFrom(String country) {
        $(".shipfrom ").click();
        switch (country) {
            case "russia":
                $("span.css_ru").click();
            case "china":
                $("span.css_cn").click();
        }
        sleep(2000);
    }
}
