package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDataProviderInternalDataProviderTest extends BaseCalculatorTest {

    @DataProvider
    public Object[][] multiplyDataProvider() {
        return new Object[][] {
                {2.0, 2.0, 4.0},
                {-9, -9, 81},
                {100, 3.0, 300.0}
        };
    }

    @Test(dataProvider = "multiplyDataProvider")
    public void parametrizedMultiplyTest(double a, double b, double expected) {
        double actual = calculator.multiply(a, b);
        assertEquals(actual, expected, 0.0000001);
    }

    @DataProvider(name = "Calculator Add operation Test Data")
    public Object[][] addDataProvider() {
        return new Object[][] {
                {2.0, 2.0, 4.0},
                {-9, -9, -18},
                {100, 3.0, 103.0}
        };
    }

    @Test(dataProvider = "Calculator Add operation Test Data")
    public void parametrizedAddTest(double a, double b, double expected) {
        double actual = calculator.add(a, b);
        assertEquals(actual, expected, 0.0000001);
    }
}
