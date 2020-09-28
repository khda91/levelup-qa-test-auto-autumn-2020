package ru.levelup.qa.at.java.conditional.operators.switchs.string;

import ru.levelup.qa.at.java.oop.incapsulation.Point;

import java.math.BigDecimal;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        CurrencyConverterService converter = new CurrencyConverterService();
        System.out.println(converter.convertToRubles("GBR", new BigDecimal(2.0)));

        Point p = new Point();
        p.w = 0.33;
    }
}
