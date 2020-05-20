package org.practice.yingjuan.fp;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@Component
public class ApplyDiscountFunction implements BiFunction<BigDecimal, BigDecimal, BigDecimal> {
    @Override
    public BigDecimal apply(BigDecimal percentage, BigDecimal price) {
        if(price.compareTo(BigDecimal.valueOf(100)) >= 0){
            var discount = price.multiply(percentage);
            return price.add(discount.negate());
        } else {
            System.out.println("\"Discount unavailable if total price is less than 100$.");
            return price;
        }
    }
}
