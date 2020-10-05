package ru.levelup.qa.at.integration.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplyCalculatorIT extends BaseCalculatorIT {

    @Test
    public void calculatorMultiplyTest() {
        System.out.println("Calculator Multiply Test Run");
        double actual = calculator.multiply(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.000001);
    }
}
