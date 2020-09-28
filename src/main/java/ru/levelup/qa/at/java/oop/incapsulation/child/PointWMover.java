package ru.levelup.qa.at.java.oop.incapsulation.child;

import ru.levelup.qa.at.java.oop.incapsulation.Point;

public class PointWMover {

    public static void movePointByZ(Point p, double smooth) {
//        p.z += smooth;
//        p.x = p.z;
        p.w += smooth;
    }

}
