package org.practice.yingjuan.fp;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@Component
public class ApplyTaxFunction implements BiFunction<BigDecimal, BigDecimal, BigDecimal> {
    @Override
    public BigDecimal apply(BigDecimal percentage, BigDecimal price) {
        return price.multiply(percentage).add(price);
    }
}
