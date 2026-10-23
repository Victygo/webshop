package se.iths.viktoriia.webshop;

import se.iths.viktoriia.webshop.model.Product;

import java.util.List;

public interface ProductStorage {
    void saveProduct(Product product);

    List<Product> getProducts();

    /** Returnerar null om ingen produkt med artikelnumret finns. */
    Product getProduct(String articleNumber);
}
