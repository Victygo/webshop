package se.iths.viktoriia.webshop;

import se.iths.viktoriia.webshop.model.Product;

import java.util.ArrayList;
import java.util.List;

/** Används bara i tester: sparar produkter i en lista i stället för i en fil. */
public class ProductListStorage implements ProductStorage {
    private List<Product> products = new ArrayList<>();

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(String articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
