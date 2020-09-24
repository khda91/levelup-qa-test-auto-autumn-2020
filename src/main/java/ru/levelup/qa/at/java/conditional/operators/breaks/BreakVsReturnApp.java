package ru.levelup.qa.at.java.conditional.operators.breaks;

public class BreakVsReturnApp {

    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    public static void main(String[] args) {
        breakFor(10);
        returnFor(3);
    }

    static void breakFor(int num) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i] == num) {
                System.out.println("Win");
                res = num;
                break;
            }
        }
        System.out.println("res: " + res);
    }

    static int returnFor(int num) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i] == num) {
                System.out.println("Lose");
                return num;
            }
        }
        throw new RuntimeException();
    }
}
