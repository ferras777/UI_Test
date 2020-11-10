package pages.selenidePages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public int getProductPrice() {
        final String regex = "(\\d+)[^,]?+";

        String string = $(".product-price-value")
                .getText()
                .replaceAll("&nbsp", "")
                .replaceAll(" ", "");

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        } else {
            return 0;
        }
    }
}