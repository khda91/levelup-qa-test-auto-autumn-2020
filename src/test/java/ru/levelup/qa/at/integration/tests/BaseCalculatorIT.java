package ru.levelup.qa.at.integration.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelup.qa.at.unit.Calculator;

public abstract class BaseCalculatorIT {

    protected Calculator calculator;

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Set up Test Suite");
    }

    @BeforeTest
    public void setUpTestTag() {
        System.out.println("Set up Test tag in suite xml");
    }

    @BeforeClass
    public void setUpTestClass() {
        System.out.println("Set up Test Class");
    }

    @BeforeMethod
    public void setUpTestMethod() {
        System.out.println("Set up Test Method");
        calculator = new Calculator();
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

    @AfterTest
    public void tearDownTestTag() {
        System.out.println("Tear down Test tag in suite xml");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Tear down Test Suite");
    }


}
