package org.practice.yingjuan.oo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxImpl implements Tax{


    @Override
    public BigDecimal applyTax(BigDecimal price) {
        return price.add(price.multiply(BigDecimal.valueOf(0.1)));
    }
}
