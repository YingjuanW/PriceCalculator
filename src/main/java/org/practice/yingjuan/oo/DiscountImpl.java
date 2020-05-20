package org.practice.yingjuan.oo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountImpl implements Discount{
    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        if (price.compareTo(BigDecimal.valueOf(100)) >= 0){
            return price.multiply(BigDecimal.valueOf(0.8));
        } else {
            System.out.println("Discount unavailable if total price is less than 100$.");
            return price;
        }
    }
}
