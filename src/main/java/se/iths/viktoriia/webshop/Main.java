package se.iths.viktoriia.webshop;

public class Main {
    public static void main(String[] args) {
        ProductStorage productStorage = new ProductFileStorage();
        OutInputHandler outInputHandler = new ConsoleOutInputHandler();
        WebShopManager webShopManager = new WebShopManager(productStorage, outInputHandler);
        webShopManager.startWebshop();
    }
}
