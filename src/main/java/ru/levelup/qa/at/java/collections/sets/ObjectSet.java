package ru.levelup.qa.at.java.collections.sets;

import ru.levelup.qa.at.java.collections.objects.Person;
import ru.levelup.qa.at.java.collections.objects.PersonComparable;
import ru.levelup.qa.at.java.collections.objects.PersonWithEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ObjectSet {

    public static void main(String[] args) {
//        System.out.println("=== Hash Set ===");
//        hashSet();
//        System.out.println("=== === === === ===");
        System.out.println("=== Tree Set ===");
        treeSet();
        System.out.println("=== === === === ===");
    }

    static void hashSet() {
        System.out.println("set without equals");
        Person vasya = new Person("Vasya", 21);
        Set<Person> setWithoutEquals = new HashSet<>();
        setWithoutEquals.add(vasya);
        setWithoutEquals.addAll(Arrays.asList(new Person("Masha", 25), new Person("Petya", 23),
                new Person("Vova", 44), new Person("Gorkiy", 17),
                new Person("Vasya", 21), new Person("Masha", 25), new Person("Sveta", 23),
                vasya));

        // 3 - vasya, 21
        // 2 - masha, 25
        // 1 - sveta, 23
        // 1 - gorkiy, 17
        // 1 - petya, 23
        // 1 - vova, 44

        System.out.println(setWithoutEquals);
        System.out.println("=======");

        System.out.println("set with equals");
        PersonWithEquals vasya1 = new PersonWithEquals("Vasya", 21);
        Set<PersonWithEquals> setWithEquals = new HashSet<>();
        setWithEquals.add(vasya1);
        setWithEquals.addAll(Arrays.asList(new PersonWithEquals("Masha", 25), new PersonWithEquals("Petya", 23),
                new PersonWithEquals("Vova", 44), new PersonWithEquals("Gorkiy", 17),
                new PersonWithEquals("Vasya", 21), new PersonWithEquals("Masha", 25),
                new PersonWithEquals("Sveta", 23), vasya1));

        // 3 - vasya, 21
        // 2 - masha, 25
        // 1 - sveta, 23
        // 1 - gorkiy, 17
        // 1 - petya, 23
        // 1 - vova, 44

        System.out.println(setWithEquals);
        System.out.println("=======");
    }

    static void treeSet() {
        System.out.println("tree set with comparable");
        PersonComparable vasya = new PersonComparable("Vasya", 21);
        Set<PersonComparable> treeSetWithComparable = new TreeSet<>();
        treeSetWithComparable.add(vasya);
        treeSetWithComparable.addAll(Arrays.asList(new PersonComparable("Masha", 25), new PersonComparable("Petya", 23),
                new PersonComparable("Vova", 44), new PersonComparable("Gorkiy", 17),
                new PersonComparable("Vasya", 21), new PersonComparable("Masha", 25),
                new PersonComparable("Sveta", 23), vasya));
        treeSetWithComparable.add(new PersonComparable("Sveta", 24));

        // 3 - vasya, 21
        // 2 - masha, 25
        // 1 - sveta, 23
        // 1 - gorkiy, 17
        // 1 - petya, 23
        // 1 - vova, 44

        System.out.println(treeSetWithComparable);
        System.out.println("=======");

        System.out.println("tree set with equals");
        PersonWithEquals vasya1 = new PersonWithEquals("Vasya", 21);
        Set<PersonWithEquals> treeSetWithComparator = new TreeSet<>(new Comparator<PersonWithEquals>() {
            @Override
            public int compare(PersonWithEquals o1, PersonWithEquals o2) {
                int namesDiff = o1.getName().compareTo(o2.getName());
                if (namesDiff == 0) {
                    return o1.getAge() - o2.getAge();
                }
                return namesDiff;
            }
        });
        treeSetWithComparator.add(vasya1);
        treeSetWithComparator.addAll(Arrays.asList(new PersonWithEquals("Masha", 25), new PersonWithEquals("Petya", 23),
                new PersonWithEquals("Vova", 44), new PersonWithEquals("Gorkiy", 17),
                new PersonWithEquals("Vasya", 21), new PersonWithEquals("Masha", 25),
                new PersonWithEquals("Sveta", 23), vasya1));
        treeSetWithComparator.add(new PersonWithEquals("Sveta", 24));

        System.out.println(treeSetWithComparator);
        System.out.println("=======");
    }
}
