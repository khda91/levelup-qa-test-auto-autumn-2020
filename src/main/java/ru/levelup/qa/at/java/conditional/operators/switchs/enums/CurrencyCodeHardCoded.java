package ru.levelup.qa.at.java.conditional.operators.switchs.enums;

import java.math.BigDecimal;

public enum CurrencyCodeHardCoded {

    USD(new BigDecimal(76)),
    EUR(new BigDecimal(91));

    private BigDecimal exchangeRate;

    CurrencyCodeHardCoded(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}
