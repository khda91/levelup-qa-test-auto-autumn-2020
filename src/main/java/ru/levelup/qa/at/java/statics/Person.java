package ru.levelup.qa.at.java.statics;

public class Person {

    public static String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Person.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + "', " +
                "email='" + email + '\'' +
                '}';
    }
}
