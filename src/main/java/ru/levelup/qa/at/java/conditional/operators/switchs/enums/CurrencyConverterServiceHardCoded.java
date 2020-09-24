package ru.levelup.qa.at.java.conditional.operators.switchs.enums;

import java.math.BigDecimal;

public class CurrencyConverterServiceHardCoded {

    public BigDecimal convertToRubles(CurrencyCodeHardCoded currencyFrom, BigDecimal amount) {
        return amount.multiply(currencyFrom.getExchangeRate());
    }
}
