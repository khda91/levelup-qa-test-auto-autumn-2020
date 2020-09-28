package ru.levelup.qa.at.java.oop.incapsulation.converter;

import ru.levelup.qa.at.java.oop.incapsulation.converter.impl.EurCurrencyConverterService;
import ru.levelup.qa.at.java.oop.incapsulation.converter.impl.JpyCurrencyConverterService;

import java.math.BigDecimal;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        CurrencyConverterService ccs = new JpyCurrencyConverterService();
        System.out.println(ccs.convertToRubles(new BigDecimal(2)));
    }
}

