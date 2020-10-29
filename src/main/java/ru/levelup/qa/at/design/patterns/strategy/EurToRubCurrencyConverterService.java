package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class EurToRubCurrencyConverterService implements CurrencyConverterService {

    private static final BigDecimal EXCHANGE_RATE = new BigDecimal(93);

    @Override
    public BigDecimal convert(BigDecimal amount) {
        return amount.multiply(EXCHANGE_RATE);
    }
}
