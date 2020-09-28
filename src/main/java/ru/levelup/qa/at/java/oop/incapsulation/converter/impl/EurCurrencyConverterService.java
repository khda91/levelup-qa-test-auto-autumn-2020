package ru.levelup.qa.at.java.oop.incapsulation.converter.impl;

import ru.levelup.qa.at.java.oop.incapsulation.converter.CurrencyConverterService;

import java.io.Serializable;
import java.math.BigDecimal;

public class EurCurrencyConverterService implements CurrencyConverterService, Serializable {

    private static final BigDecimal EURO_EXCHANGE_RATE = new BigDecimal(92);

    @Override
    public BigDecimal convertToRubles(BigDecimal amount) {
        return amount.multiply(EURO_EXCHANGE_RATE);
    }

    @Override
    public String getCurrencyName() {
        return "EUR";
    }
}
