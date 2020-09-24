package ru.levelup.qa.at.java.statics;

public class StaticApp {

    public static void main(String[] args) {
        String emptyString = "";
        String nullString = null;
        String someString = "some";

        System.out.println("empty String : " + StringUtils.isEmpty(emptyString));
        System.out.println("null String : " + StringUtils.isEmpty(nullString));
        System.out.println("some String : " + StringUtils.isEmpty(someString));

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println();

        Person p1 = new Person();
        p1.setEmail("email@email.com");
        p1.setName("p1");
        System.out.println(p1);

        Person p2 = new Person();
        p2.setEmail("email_p2@email.com");
        p2.setName("p2");

        System.out.println(p2);
        System.out.println(p1);

        Person.name = "Vovka";
        System.out.println(p2);
        System.out.println(p1);
    }
}
