package ru.levelup.qa.at.java.oop.incapsulation.converter;

import ru.levelup.qa.at.java.oop.incapsulation.converter.impl.EurCurrencyConverterService;
import ru.levelup.qa.at.java.oop.incapsulation.converter.impl.JpyCurrencyConverterService;

import java.math.BigDecimal;

public class MultiCurrencyConverterApp {

    public static void main(String[] args) {
        CurrencyConverterService[] ccsArray = {new JpyCurrencyConverterService(), new EurCurrencyConverterService()};
        for (CurrencyConverterService ccs : ccsArray) {
            System.out.println(ccs.getCurrencyName() + ": " + ccs.convertToRubles(new BigDecimal(2)));
        }
    }
}

