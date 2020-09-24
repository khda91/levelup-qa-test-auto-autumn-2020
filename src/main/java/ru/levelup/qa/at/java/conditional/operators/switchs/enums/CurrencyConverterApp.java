package ru.levelup.qa.at.java.conditional.operators.switchs.enums;

import java.math.BigDecimal;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        CurrencyConverterService converter = new CurrencyConverterService();
        System.out.println(converter.convertToRubles(CurrencyCode.EUR, new BigDecimal(2.0)));
    }
}
