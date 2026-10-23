package se.iths.viktoriia.webshop;

import se.iths.viktoriia.webshop.model.Discount;
import se.iths.viktoriia.webshop.model.HalfPriceDiscount;
import se.iths.viktoriia.webshop.model.Product;
import se.iths.viktoriia.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {
    private ProductStorage productStorage;
    private OutInputHandler outInputHandler;

    public WebShopManager(ProductStorage productStorage, OutInputHandler outInputHandler) {
        this.productStorage = productStorage;
        this.outInputHandler = outInputHandler;
    }

    // Package-private så att testklasser i samma paket kan anropa dem
    void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    Product getProductFromStorage(String articleNumber) {
        return productStorage.getProduct(articleNumber);
    }

    public void startWebshop() {
        String discountCode = outInputHandler.prompt("Ange rabattkod: ");
        Discount discount;
        if (discountCode.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount();
        } else {
            discount = new TenPercentDiscount();
        }

        boolean running = true;
        while (running) {
            String choice = outInputHandler.menu();
            switch (choice.trim()) {
                case "1" -> addProduct();
                case "2" -> listProducts(discount);
                case "3" -> showProduct(discount);
                case "4" -> {
                    outInputHandler.info("Programmet avslutas.");
                    running = false;
                }
                default -> outInputHandler.info("Ogiltigt val, försök igen.");
            }
        }
    }

    private void addProduct() {
        String articleNumber = outInputHandler.prompt("Ange artikelnummer: ");
        String title = outInputHandler.prompt("Ange titel: ");
        double price;
        try {
            price = Double.parseDouble(outInputHandler.prompt("Ange pris: ").trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            outInputHandler.info("Ogiltigt pris. Produkten sparades inte.");
            return;
        }
        String description = outInputHandler.prompt("Ange beskrivning: ");

        Product product = new Product(articleNumber, title, price, description);
        saveProductToStorage(product);
        outInputHandler.info("Produkten har sparats");
    }

    private void listProducts(Discount discount) {
        List<Product> products = getProductsFromStorage();
        if (products.isEmpty()) {
            outInputHandler.info("Det finns inga produkter.");
            return;
        }
        for (Product product : products) {
            outInputHandler.info(productText(product, discount) + "\n");
        }
    }

    private void showProduct(Discount discount) {
        String articleNumber = outInputHandler.prompt("Ange artikelnummer: ");
        Product product = getProductFromStorage(articleNumber);
        if (product == null) {
            outInputHandler.info("Ingen produkt med artikelnummer " + articleNumber + " hittades.");
        } else {
            outInputHandler.info(productText(product, discount));
        }
    }

    private String productText(Product product, Discount discount) {
        double discountedPrice = discount.calculatePrice(product.getPrice());
        return product + "\n"
                + "Rabatterat pris (" + discount.getDescription() + "): " + discountedPrice;
    }
}
