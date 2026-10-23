package se.iths.viktoriia.webshop.model;

public class TenPercentDiscount extends Discount {

    public TenPercentDiscount() {
        super("10 procent rabatt");
    }

    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * 0.9;
    }
}
