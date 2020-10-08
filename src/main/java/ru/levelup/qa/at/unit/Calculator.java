package ru.levelup.qa.at.unit;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double divide(int a, int b) {
        return a / b;
    }

    public double power(double a, int power) {
        double res = 1;
        for (int i = 0; i < power; i++) {
            res *= a;
        }
        return res;
    }

}
