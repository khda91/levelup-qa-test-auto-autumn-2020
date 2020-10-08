package ru.levelup.qa.at.unit.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SimpleListener.class})
public class ListenerCalculatorTest extends BaseCalculatorTest {

    @Test(testName = "Calculator Multiply Test With Listener")
    public void calculatorMultiplyTest() {
        double actual = calculator.multiply(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.000001);
    }
}
