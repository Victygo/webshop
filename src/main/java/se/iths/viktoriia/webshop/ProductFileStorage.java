package se.iths.viktoriia.webshop;

import se.iths.viktoriia.webshop.model.Product;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    private Path file = Path.of("products.txt");

    @Override
    public void saveProduct(Product product) {
        String line = product.toFileLine() + System.lineSeparator();
        try {
            // CREATE skapar filen om den saknas, APPEND lägger till sist utan att tömma filen
            Files.writeString(file, line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException("Kunde inte spara produkten", e);
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        if (!Files.exists(file)) {
            return products;
        }
        try {
            List<String> lines = Files.readAllLines(file);
            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                products.add(Product.fromFileLine(line));
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Kunde inte läsa produkterna", e);
        }
        return products;
    }

    @Override
    public Product getProduct(String articleNumber) {
        List<Product> products = getProducts();
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
