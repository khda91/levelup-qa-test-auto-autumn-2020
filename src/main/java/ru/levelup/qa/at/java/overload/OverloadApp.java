package ru.levelup.qa.at.java.overload;

public class OverloadApp {

    public static void main(String[] args) {
        double sumDouble = sum(1.2, 36.0);
        double sumInt = sum(1, 3);
        long sumLong = sum(9999999999999L, 9999999999L);
    }

    static double sum (int a, int b) {
        return a + b;
    }

    static double sum (double a, double b) {
        return a + b;
    }

    static long sum (long a, long b) {
        return a + b;
    }
}
