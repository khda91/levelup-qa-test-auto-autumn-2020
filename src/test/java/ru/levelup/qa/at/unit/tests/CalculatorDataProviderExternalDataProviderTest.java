package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDataProviderExternalDataProviderTest extends BaseCalculatorTest {

    @Test(dataProviderClass = CalculatorExternalDataProvider.class, dataProvider = "divideDataProvider")
    public void parametrizedDivideTest(double a, double b, double expected) {
        double actual = calculator.divide(a, b);
        assertEquals(actual, expected, 0.0000001);
    }

    @Test(dataProviderClass = CalculatorExternalDataProvider.class, dataProvider = "Calculator Power operation Test Data")
    public void parametrizedPowerTest(double a, int b, double expected) {
        double actual = calculator.power(a, b);
        assertEquals(actual, expected, 0.0000001);
    }
}
