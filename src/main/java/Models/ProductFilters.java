package Models;

public enum ProductFilters {

    popularity("popularity"),
    rating("rating"),
    date("date"),
    price("price"),
    priceDesc("price-desc");

    String name;

    ProductFilters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
