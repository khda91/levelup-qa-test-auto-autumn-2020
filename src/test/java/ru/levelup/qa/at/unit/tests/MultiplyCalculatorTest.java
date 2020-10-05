package ru.levelup.qa.at.unit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplyCalculatorTest extends BaseCalculatorTest {

    @Test
    public void calculatorMultiplyTest() {
        System.out.println("Calculator Multiply Test Run");
        double actual = calculator.multiply(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.000001);
    }
}
