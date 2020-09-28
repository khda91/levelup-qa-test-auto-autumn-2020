package ru.levelup.qa.at.java.oop.incapsulation;

public class App {

    public static void main(String[] args) {
        Point p = new Point();
//        p.x = 1.2; - нельзя
        p.z = 3.25;

        p.w = 4.75;
        p.setX(15.375);
        p.setY(5.375);
    }

}
