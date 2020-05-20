package org.practice.yingjuan.oo;

import org.practice.yingjuan.IApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("ooApplication")
public class Application implements IApplication {
    private final Pricing pricing;

    Application(Pricing pricing) {
        this.pricing = pricing;
    }

    public BigDecimal run(BigDecimal listingPrice) {
        return pricing.calculate(listingPrice);
    }
}
