package ru.levelup.qa.at.design.patterns.singleton;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingletonTest {

    @BeforeClass
    public void setUp() {
        System.out.println("Before class singleton state: " + Singleton.INSTANCE.getState());
    }

    @Test
    public void test1() {
        System.out.println("Test 1 begin singleton state: " + Singleton.INSTANCE.getState());
        Singleton.INSTANCE.setState("state");
        System.out.println("Test 1 end singleton state: " + Singleton.INSTANCE.getState());
    }

    @Test
    public void test2() {
        System.out.println("Test 2 begin singleton state: " + Singleton.INSTANCE.getState());
        Singleton.INSTANCE.setState("simple");
        System.out.println("Test 2 end singleton state: " + Singleton.INSTANCE.getState());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method singleton state: " + Singleton.INSTANCE.getState());
    }
}
