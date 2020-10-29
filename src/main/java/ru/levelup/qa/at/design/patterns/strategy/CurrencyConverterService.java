package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface CurrencyConverterService {

    BigDecimal convert(BigDecimal amount);

}
