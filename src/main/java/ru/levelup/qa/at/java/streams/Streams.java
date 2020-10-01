package ru.levelup.qa.at.java.streams;

import ru.levelup.qa.at.java.collections.objects.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Vova", 23));
        list.add(new Person("Vova", 23));
        list.add(new Person("Vasya", 43));
        list.add(new Person("Vasya", 43));
        list.add(new Person("Vasya", 43));
        list.add(new Person("Vasya", 43));
        list.add(new Person("Masha", 25));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Lesha", 32));
        list.add(new Person("Sveta", 33));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));
        list.add(new Person("Olga", 20));

        // до стримов
        List<String> names = new ArrayList<>();
        for (Person p : list) {
            names.add(p.getName());
        }
        System.out.println(names);
        System.out.println();
        System.out.println();
        System.out.println();

        // стимы
        List<String> namesStream = list.stream().map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(namesStream);
        System.out.println();
        System.out.println();
        System.out.println();

        // Уникальные имена старше 32
        // до стримов
        Set<String> uniqueNamesSet = new HashSet<>();
        for (Person person : list) {
            if (person.getAge() > 32) {
                uniqueNamesSet.add(person.getName());
            }
        }
        System.out.println(uniqueNamesSet);
        System.out.println();
        System.out.println();
        System.out.println();

        // стимы
        Set<String> uniqueNamesSetStream = list.stream().filter(p -> p.getAge() > 32).map(Person::getName).collect(Collectors.toSet());
        System.out.println(uniqueNamesSetStream);
        System.out.println();
        System.out.println();
        System.out.println();

        List<String> collect = list.stream()
                .filter(p -> p.getAge() > 32)
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
