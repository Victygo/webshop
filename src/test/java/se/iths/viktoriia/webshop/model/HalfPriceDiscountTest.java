package se.iths.viktoriia.webshop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HalfPriceDiscountTest {

    @Test
    void calculatePriceGivesHalfPrice() {
        HalfPriceDiscount discount = new HalfPriceDiscount();
        double price = 100.0;

        double discountedPrice = discount.calculatePrice(price);

        Assertions.assertEquals(50.0, discountedPrice, 0.0001);
    }
}
