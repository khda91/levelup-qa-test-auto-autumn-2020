package ru.levelup.qa.at.integration.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.Calculator;

public class CalculatorIT1000 {

    private Calculator calculator;

    @BeforeClass
    public void setUpTestClass() {
        System.out.println("Set up Test Class");
    }

    @BeforeMethod
    public void setUpTestMethod() {
        System.out.println("Set up Test Method");
        calculator = new Calculator();
    }

    @Test
    public void calculatorAddTest() {
        System.out.println("Calculator Add Test Run");
        double actual = calculator.add(2.0, 2.0);
        Assert.assertEquals(actual, 4.0, 0.000001);
    }

    @Test
    public void calculatorDivideTest() {
        System.out.println("Calculator Divide Test Run");
        double actual = calculator.divide(2.0, 2.0);
        Assert.assertEquals(actual, 1.0, 0.000001);
    }

    @AfterMethod
    public void tearDownTestMethod() {
        System.out.println("Tear down Test Method");
        calculator = null;
    }

    @AfterClass
    public void tearDownTestClass() {
        System.out.println("Tear down Test Class");
    }

}
