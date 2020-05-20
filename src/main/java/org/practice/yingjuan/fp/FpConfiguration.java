package org.practice.yingjuan.fp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

@Configuration
public class FpConfiguration {

    @Bean
    public Function<BigDecimal, BigDecimal> calculateFinalPriceForListingPrice(
            @Value("${pricecalculator.discount.percentage}") String discountPercentageString,
            @Value("${pricecalculator.tax.percentage}") String taxPercentageString,
            BiFunction<BigDecimal, BigDecimal, BigDecimal> applyDiscountFunction,
            BiFunction<BigDecimal, BigDecimal, BigDecimal> applyTaxFunction,
            CalculateFinalPriceFunction calculateFinalPriceFunction
    ) {
        var discountPercentage = new BigDecimal(discountPercentageString);
        var taxPercentage = new BigDecimal(taxPercentageString);
        return generateCurriedCalculateFinalPrice(discountPercentage, taxPercentage, applyDiscountFunction, applyTaxFunction, calculateFinalPriceFunction);
    }

    private Function<BigDecimal, BigDecimal> generateCurriedCalculateFinalPrice(
            BigDecimal discountRate,
            BigDecimal taxRate,
            BiFunction<BigDecimal, BigDecimal, BigDecimal> applyDiscount,
            BiFunction<BigDecimal, BigDecimal, BigDecimal> applyTax,
            CalculateFinalPriceFunction calculateFinalPriceFunction
    ) {
        var applyDiscountForAmount = curry(applyDiscount).apply(discountRate);
        var applyTaxForAmount = curry(applyTax).apply(taxRate);
        var calculateFinalPriceForListingPrice = curry(calculateFinalPriceFunction)
                .apply(applyDiscountForAmount)
                .apply(applyTaxForAmount);
        return calculateFinalPriceForListingPrice;
    }

    private Function<BigDecimal, Function<BigDecimal, BigDecimal>>
    curry(BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        return t -> u -> function.apply(t, u);
    }

    private Function<Function<BigDecimal, BigDecimal>, Function<Function<BigDecimal, BigDecimal>, Function<BigDecimal, BigDecimal>>>
    curry(CalculateFinalPriceFunction function) {
        return applyDiscountForAmount -> applyTaxForAmount -> listingPrice ->
                function.apply(applyDiscountForAmount, applyTaxForAmount, listingPrice);
    }
}
