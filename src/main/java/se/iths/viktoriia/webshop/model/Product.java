package se.iths.viktoriia.webshop.model;

public class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toFileLine() {
        return articleNumber + ";" + title + ";" + price + ";" + description;
    }

    public static Product fromFileLine(String line) {
        // limit 4 gör att eventuella semikolon i beskrivningen bevaras
        String[] array = line.split(";", 4);
        String articleNumber = array[0];
        String title = array[1];
        double price = Double.parseDouble(array[2]);
        String description = array[3];
        return new Product(articleNumber, title, price, description);
    }

    @Override
    public String toString() {
        return "Artikelnummer: " + articleNumber + "\n"
                + "Titel: " + title + "\n"
                + "Pris: " + price + "\n"
                + "Beskrivning: " + description;
    }
}
