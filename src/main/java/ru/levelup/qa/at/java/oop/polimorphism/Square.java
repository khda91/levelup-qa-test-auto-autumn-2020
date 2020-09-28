package ru.levelup.qa.at.java.oop.polimorphism;

import java.io.Serializable;

public class Square extends Rectangle implements Serializable, SomeInterface {

    public Square(double x, double y, double width) {
        super(x, y, width, width);
    }

    @Override
    public void draw() {
        System.out.println("draw " + this.getClass().getCanonicalName());
    }
}
