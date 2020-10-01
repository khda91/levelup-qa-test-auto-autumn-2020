package ru.levelup.qa.at.java.generics;

import ru.levelup.qa.at.java.collections.objects.Person;

import java.util.ArrayList;

public class JavaOnePointForWithoutGenerics {

    public static void main(String[] args) {
        // Пример списка объектов
        ArrayList list = new ArrayList();
        list.add("mama");
        list.add(Double.valueOf(25.6D));
        list.add(System.currentTimeMillis());
        list.add(new Person("generic", 1));

        ArrayList listString = new ArrayList();
        listString.add("vova");
        listString.add("vasya");
        listString.add("masha");
        listString.add(new Person("generic", 1));

        for (Object o : listString) {
            if (o instanceof String) {
                String str = (String) o;
                System.out.println(String.format("%s%s", str.substring(0, 1).toUpperCase(), str.substring(1)));
            }
        }
    }

}
