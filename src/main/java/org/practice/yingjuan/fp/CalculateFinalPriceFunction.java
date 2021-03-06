package org.practice.yingjuan.fp;

import java.math.BigDecimal;
import java.util.function.Function;

@FunctionalInterface
public interface CalculateFinalPriceFunction {
    BigDecimal apply(Function<BigDecimal, BigDecimal> applyDiscount, Function<BigDecimal, BigDecimal> applyTax, BigDecimal listingPrice);
}
