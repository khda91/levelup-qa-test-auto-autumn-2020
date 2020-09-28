package ru.levelup.qa.at.java.oop.incapsulation.converter;

import java.math.BigDecimal;

public interface CurrencyConverterService {

    BigDecimal convertToRubles(BigDecimal amount);

    String getCurrencyName();
}
