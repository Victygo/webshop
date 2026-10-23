package se.iths.viktoriia.webshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.viktoriia.webshop.model.Product;

import java.util.List;

class WebShopManagerTest {

    // OutInputHandler behövs inte för de metoder som testas, därför null
    private WebShopManager createManager() {
        ProductListStorage storage = new ProductListStorage();
        return new WebShopManager(storage, null);
    }

    @Test
    void saveTwoProductsGivesListOfTwo() {
        WebShopManager manager = createManager();
        Product p1 = new Product("B001", "Clean Code", 299.0, "En bok om programmering");
        Product p2 = new Product("E001", "Hörlurar", 499.0, "Trådlösa hörlurar");

        manager.saveProductToStorage(p1);
        manager.saveProductToStorage(p2);
        List<Product> products = manager.getProductsFromStorage();

        Assertions.assertEquals(2, products.size());
    }

    @Test
    void getSavedProductByArticleNumber() {
        WebShopManager manager = createManager();
        Product product = new Product("C001", "T-shirt", 149.0, "Svart t-shirt");
        manager.saveProductToStorage(product);

        Product found = manager.getProductFromStorage("C001");

        Assertions.assertEquals("C001", found.getArticleNumber());
    }

    @Test
    void missingProductReturnsNull() {
        WebShopManager manager = createManager();

        Product found = manager.getProductFromStorage("FINNS-INTE");

        Assertions.assertNull(found);
    }
}
