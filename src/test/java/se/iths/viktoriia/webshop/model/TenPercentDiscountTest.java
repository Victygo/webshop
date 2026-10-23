package se.iths.viktoriia.webshop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TenPercentDiscountTest {

    @Test
    void calculatePriceGivesTenPercentOff() {
        TenPercentDiscount discount = new TenPercentDiscount();
        double price = 100.0;

        double discountedPrice = discount.calculatePrice(price);

        Assertions.assertEquals(90.0, discountedPrice, 0.0001);
    }
}
