package ru.levelup.qa.at.java.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringSet {

    public static void main(String[] args) {
//        System.out.println("=== Hash Set ===");
//        hashSet();
//        System.out.println("=== === === === ===");
//        System.out.println("=== Linked Hash Set ===");
//        linkedHashSet();
//        System.out.println("=== === === === ===");
        System.out.println("=== Tree Set ===");
        treeSet();
        System.out.println("=== === === === ===");
    }

    static void hashSet() {
        Set<String> set = new HashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("myla");
        set.add("ramy");
        set.add("papa");
        set.add("mama");

        System.out.println(set);
        System.out.println("=======");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======");

        set.remove("mama");
        System.out.println(set);
        System.out.println("=======");
    }

    static void linkedHashSet() {
        Set<String> set = new LinkedHashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("myla");
        set.add("ramy");
        set.add("papa");
        set.add("mama");

        System.out.println(set);
        System.out.println("=======");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======");

        set.remove("mama");
        System.out.println(set);
        System.out.println("=======");
    }

    static void treeSet() {
        Set<String> set = new TreeSet<>();
        set.add("mama");
        set.add("papa");
        set.add("myla");
        set.add("ramy");
        set.add("papa");
        set.add("mama");

        System.out.println(set);
        System.out.println("=======");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======");

        set.remove("mama");
        System.out.println(set);
        System.out.println("=======");
    }
}
