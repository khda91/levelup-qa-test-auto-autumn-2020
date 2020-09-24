package ru.levelup.qa.at.java.links.type;

public class AppSimpleClass {

    public static void main(String[] args) {
        SimpleClass scVasya = new SimpleClass("Vasya");
        System.out.println("scVasya name = " + scVasya.getName());

        SimpleClass scPetya = new SimpleClass("Petya");
        scPetya.setName("Petya");
        System.out.println("scVasya name = " + scVasya.getName());
        System.out.println("scPetya name = " + scPetya.getName());
    }
}
