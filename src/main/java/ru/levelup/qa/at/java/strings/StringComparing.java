package ru.levelup.qa.at.java.strings;

public class StringComparing {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";

        String aa = new String("dfe");
        String bb = new String("dfe");

        System.out.println("a == b: " + (a == b));
        System.out.println("aa == bb: " + (aa == bb));
        System.out.println("aa.equals(bb): " + (aa.equals(bb)));
    }

}
