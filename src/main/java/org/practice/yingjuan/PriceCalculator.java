package org.practice.yingjuan;

import org.practice.yingjuan.oo.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PriceCalculator implements CommandLineRunner {
    private final IApplication ooApplication;
    private final IApplication fpApplication;

    @Autowired
    PriceCalculator(IApplication ooApplication,
                    IApplication fpApplication) {
        this.ooApplication = ooApplication;
        this.fpApplication = fpApplication;
    }

    public static void main(String[] args) {
        SpringApplication.run(PriceCalculator.class, args);
    }

    @Override
    public void run(String... args) {
        BigDecimal listingPrice1 = BigDecimal.valueOf(100);
        BigDecimal listingPrice2 = BigDecimal.valueOf(90);

        System.out.println(ooApplication.getClass().getName());
        System.out.println(ooApplication.run(listingPrice1));
        System.out.println(ooApplication.run(listingPrice2));

        System.out.println(fpApplication.getClass().getName());
        System.out.println(fpApplication.run(listingPrice1));
        System.out.println(fpApplication.run(listingPrice2));
    }
}
