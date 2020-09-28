package ru.levelup.qa.at.java.oop.inheretance;

public class App {

    public static void main(String[] args) {
        Circle circle = new Circle(2.0, 5.0, 3.6);
        circle.diameter();

        Rectangle rectangle = new Rectangle(3.0, -6.8, 25, 58);
        rectangle.square();

        Square square = new Square(0, 0, 6);
        square.square();
    }
}
