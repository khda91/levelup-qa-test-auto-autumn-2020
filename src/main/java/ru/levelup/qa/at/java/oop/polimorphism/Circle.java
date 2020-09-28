package ru.levelup.qa.at.java.oop.polimorphism;

public class Circle extends Shape {

    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("draw " + this.getClass().getCanonicalName());
    }

    public double diameter() {
        return radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
