package ru.levelup.qa.at.java.conditional.operators.switchs.string;

import java.math.BigDecimal;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        CurrencyConverterService converter = new CurrencyConverterService();
        System.out.println(converter.convertToRubles("GBR", new BigDecimal(2.0)));
    }
}
