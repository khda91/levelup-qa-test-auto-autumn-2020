package ru.levelup.qa.at.utils;

public class Utils {

    private Utils() {

    }

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
