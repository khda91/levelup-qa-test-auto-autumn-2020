package ru.levelup.qa.at.design.patterns.builder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonBuilderTest {


    @Test
    public void testName() {
        Person vasya = Person.builder()
                .setAge(10)
                .setFirstName("Vasya")
                .build();
        System.out.println(vasya);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {Person.builder().setFirstName("vovka").setAge(15).setEmail("vovka@vovka.com").build()},
                {Person.builder().setLastName("Ivanov").setAge(23).build()},
                {Person.builder().setEmail("vovka@vovka.com").build()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testBuilderEntityDataProvider(Person person) {
        System.out.println(person);
    }
}
