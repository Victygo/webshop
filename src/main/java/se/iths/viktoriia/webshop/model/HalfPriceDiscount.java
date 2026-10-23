package se.iths.viktoriia.webshop.model;

public class HalfPriceDiscount extends Discount {

    public HalfPriceDiscount() {
        super("Halva priset");
    }

    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * 0.5;
    }
}
