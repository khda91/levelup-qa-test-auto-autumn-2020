package ru.levelup.qa.at.java.conditional.operators.switchs.string;

import java.math.BigDecimal;

public class CurrencyConverterService {

    public BigDecimal convertToRubles(String currencyFrom, BigDecimal amount) {
        switch (currencyFrom) {
            case "USD":
                return amount.multiply(new BigDecimal("76"));
            case "EUR":
                return amount.multiply(new BigDecimal("91"));
            default:
                throw new IllegalArgumentException("Unsupported currency " + currencyFrom);
        }
    }
}
