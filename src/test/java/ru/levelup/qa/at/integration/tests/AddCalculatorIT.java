package ru.levelup.qa.at.integration.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCalculatorIT extends BaseCalculatorIT {

    @Test
    public void calculatorAddTest() {
        System.out.println("Calculator Add Test Run");
        double actual = calculator.add(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.000001);
    }
}
