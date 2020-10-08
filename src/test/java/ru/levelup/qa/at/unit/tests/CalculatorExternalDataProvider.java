package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.DataProvider;

public class CalculatorExternalDataProvider {

    @DataProvider
    public Object[][] divideDataProvider() {
        return new Object[][] {
                {2.0, 2.0, 1.0},
                {-9, 3, -3},
                {100, 10.0, 10.0}
        };
    }

    @DataProvider(name = "Calculator Power operation Test Data")
    public Object[][] powerDataProvider() {
        return new Object[][] {
                {2.0, 2, 4.0},
                {-9, 2, 81},
                {2, 10, 1024.0}
        };
    }
}
