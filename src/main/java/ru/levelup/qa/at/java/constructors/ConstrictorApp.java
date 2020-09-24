package ru.levelup.qa.at.java.constructors;

public class ConstrictorApp {

    public static void main(String[] args) {
        SimpleClass sc1 = new SimpleClass("sc1");
        System.out.println("sc1: " + sc1.getName());

        SimpleClass sc2 = new SimpleClass();
        System.out.println("sc1: " + sc2.getName());

    }

}
