package org.practice.yingjuan.oo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PricingImpl implements Pricing{
    private final Discount discount;
    private final Tax tax;

    public PricingImpl(Discount discount, Tax tax) {
        this.discount = discount;
        this.tax = tax;
    }

    @Override
    public BigDecimal calculate(BigDecimal listingPrice) {
        return tax.applyTax(discount.applyDiscount(listingPrice));
    }
}
