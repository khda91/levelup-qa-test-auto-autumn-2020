package ru.levelup.qa.at.java.oop.polimorphism;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("draw " + this.getClass().getCanonicalName());
    }

    public double square() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
