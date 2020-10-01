package ru.levelup.qa.at.java.collections.maps;

import ru.levelup.qa.at.java.collections.objects.Person;
import ru.levelup.qa.at.java.collections.objects.PersonWithEquals;

import java.util.HashMap;
import java.util.Map;

public class ObjectMap {

    public static void main(String[] args) {
        Map<Person, Person> husbandAndWife = new HashMap<>();
        Person masha = new Person("masha", 23);
        Person petya = new Person("petya", 24);
        husbandAndWife.put(petya, masha);
        husbandAndWife.put(new Person("Vova", 34), new Person("Sveta", 30));
        husbandAndWife.put(new Person("Serega", 30), new Person("Oksana", 32));
        husbandAndWife.put(new Person("petya", 24), new Person("Elena", 20));
        husbandAndWife.put(new Person("Vova", 34), new Person("Sveta", 30));

        System.out.println(husbandAndWife);
        System.out.println("===== === === =====");
        System.out.println();

        Map<PersonWithEquals, PersonWithEquals> husbandAndWife2 = new HashMap<>();
        PersonWithEquals masha1 = new PersonWithEquals("masha", 23);
        PersonWithEquals petya1 = new PersonWithEquals("petya", 24);
        husbandAndWife2.put(petya1, masha1);
        husbandAndWife2.put(new PersonWithEquals("Vova", 34), new PersonWithEquals("Sveta", 30));
        husbandAndWife2.put(new PersonWithEquals("Serega", 30), new PersonWithEquals("Oksana", 32));
        husbandAndWife2.put(new PersonWithEquals("petya", 24), new PersonWithEquals("Elena", 20));
        husbandAndWife2.put(new PersonWithEquals("Vova", 34), new PersonWithEquals("Sveta", 30));

        System.out.println(husbandAndWife2);
        System.out.println("===== === === =====");
    }

}
