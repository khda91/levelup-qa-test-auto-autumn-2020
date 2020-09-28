package ru.levelup.qa.at.java.oop.polimorphism;

public abstract class Shape {

    private double x;
    private double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public abstract void draw();

    public void draw() {
        System.out.println("draw " + this.getClass().getCanonicalName());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Deprecated
    /**
     * @deprecated please use getYY
     */
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
