package ru.levelup.qa.at.java.generics;

import java.math.BigDecimal;

public class PairApp {

    public static void main(String[] args) {
        Pair<BigDecimal, BigDecimal> coords = new Pair<>(new BigDecimal(25.33), new BigDecimal(98.46));
        System.out.println("coords: " + coords);

        Pair<String, String> pair = new Pair<>("Name A", "Name B");
    }
}
