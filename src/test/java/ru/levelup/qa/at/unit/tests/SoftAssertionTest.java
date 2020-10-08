package ru.levelup.qa.at.unit.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class SoftAssertionTest extends BaseCalculatorTest {

    @Test
    public void hardAssertionTest() {
        // 2 + 2 = 4
        // 6 + 8 = 14
        // 6 * 6 = 36
        // 48 / 8 = 6
        assertEquals(calculator.add(2, 2), 4.0, 0.00001);
        assertEquals(calculator.add(6, 8), 14, 0.00001);
        assertEquals(calculator.multiply(6, 6), 36, 0.00001);
        assertEquals(calculator.divide(48, 8), 6, 0.00001);
    }

    @Test
    public void softAssertionTest() {
        // 2 + 2 = 4
        // 6 + 8 = 14
        // 6 * 6 = 36
        // 48 / 8 = 6
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.add(2, 2), 4.0, 0.00001);
        softAssert.assertEquals(calculator.add(6, 8), 14, 0.00001);
        softAssert.assertEquals(calculator.multiply(6, 6), 36, 0.00001);
        softAssert.assertEquals(calculator.divide(48, 8), 6, 0.00001);

        softAssert.assertAll();
    }
}
