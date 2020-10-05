package ru.levelup.qa.at.unit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivideCalculatorTest extends BaseCalculatorTest {

    @Test
    public void calculatorDivideTest() {
        System.out.println("Calculator Divide Test Run");
        double actual = calculator.divide(2.0, 2.0);
        Assert.assertEquals(actual, 1.0, 0.000001);
    }

    @Test
    public void calculatorDivideOnZeroTest() {
        System.out.println("Calculator Divide On Zero Test Run");
        double actual = calculator.divide(2, 1);
        Assert.assertEquals(actual, 2, 0.000001);
    }
}
