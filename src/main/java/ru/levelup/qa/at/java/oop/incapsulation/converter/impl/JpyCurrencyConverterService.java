package ru.levelup.qa.at.java.oop.incapsulation.converter.impl;

import ru.levelup.qa.at.java.oop.incapsulation.converter.CurrencyConverterService;

import java.math.BigDecimal;

public class JpyCurrencyConverterService implements CurrencyConverterService {

    private static final BigDecimal JPY_EXCHANGE_RATE = new BigDecimal(0.75);

    @Override
    public BigDecimal convertToRubles(BigDecimal amount) {
        return amount.multiply(JPY_EXCHANGE_RATE);
    }

    @Override
    public String getCurrencyName() {
        return "JPY";
    }

}
