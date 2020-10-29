package ru.levelup.qa.at.design.patterns.singleton;

import org.testng.annotations.Test;

public class SingletonTest2 {

    @Test
    public void test1() {
        System.out.println("SingletonTest2 Test 1 begin singleton state: " + Singleton.INSTANCE.getState());
        Singleton.INSTANCE.setState("SingletonTest2 ");
        System.out.println("SingletonTest2 Test 1 end singleton state: " + Singleton.INSTANCE.getState());
    }

    @Test
    public void test2() {
        System.out.println("SingletonTest2 Test 2 begin singleton state: " + Singleton.INSTANCE.getState());
        Singleton.INSTANCE.setState("simple");
        System.out.println("SingletonTest2 Test 2 end singleton state: " + Singleton.INSTANCE.getState());
    }
}
