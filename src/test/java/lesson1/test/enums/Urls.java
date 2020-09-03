package lesson1.test.enums;

public enum Urls {
    SITE("https://aliexpress.ru/"),
    CART("https://shoppingcart.aliexpress.ru/shopcart/shopcartDetail.htm"),
    WISHLIST("https://my.aliexpress.ru/wishlist/wish_list_product_list.htm");

    private String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
