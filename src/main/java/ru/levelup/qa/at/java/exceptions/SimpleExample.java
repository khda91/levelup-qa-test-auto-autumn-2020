package ru.levelup.qa.at.java.exceptions;

public class SimpleExample {

    public static void main(String[] args) {
        check("abc");

        System.out.println("Finish");
    }

    static Integer check(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {

        }
        return null;
    }
}
