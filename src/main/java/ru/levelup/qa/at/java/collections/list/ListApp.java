package ru.levelup.qa.at.java.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {

    public static void main(String[] args) {
        System.out.println("=== Array List ===");
        arrayList();
        System.out.println("=== ========== ===");
        System.out.println("=== Linked List ===");
        linkedList();
        System.out.println("=== ========== ===");
    }

    static void arrayList() {
        List<String> list = new ArrayList<>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        list.add("item 4");
        list.add("item 5");

        System.out.println(list);
        System.out.println("=======");

        list.add(3, "item 6");
        list.set(1, "item 7");

        System.out.println(list);
        System.out.println("=======");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=======");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=======");
    }

    static void linkedList() {
        List<String> list = new LinkedList<>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        list.add("item 4");
        list.add("item 5");

        System.out.println(list);
        System.out.println("=======");

        list.add(3, "item 6");
        list.set(1, "item 7");

        System.out.println(list);
        System.out.println("=======");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=======");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=======");
    }

}
