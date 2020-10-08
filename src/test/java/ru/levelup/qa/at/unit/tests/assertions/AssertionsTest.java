package ru.levelup.qa.at.unit.tests.assertions;

import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.Person;
import ru.levelup.qa.at.unit.PersonProvider;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.testng.Assert.assertTrue;

public class AssertionsTest {

    @Test
    public void collectionTestNgTest() {
        List<String> actualCollection = Arrays.asList("mama", "papa", "dochya", "syna", "dog");
        String item = "cat";
        assertTrue(actualCollection.contains(item),
                String.format("Collection '%s' does not contains '%s'", actualCollection, item));
    }

    @Test
    public void collectionHamcrestTest1() {
        List<String> actualCollection = Arrays.asList("mama", "papa", "dochya", "syna", "dog");
        String item = "cat";
        assertThat(actualCollection, hasItem(item));
    }

    @Test
    public void collectionHamcrestTest2() {
        List<String> actualCollection = Arrays.asList("mama", "papa", "dochya", "syna", "dog");
        List<String> expectedCollection = Arrays.asList("syna", "mama", "dochya", "papa", "dog");
        assertThat(actualCollection, containsInAnyOrder(expectedCollection.toArray()));
    }

    @Test
    public void beansHamcrestTest1() {
        Person johnDowPerson = PersonProvider.createJohnDowPerson();
        assertThat(johnDowPerson, hasProperty("firstName"));
    }

    @Test
    public void beansHamcrestTest2() {
        Person johnDowPerson = PersonProvider.createJohnDowPerson();
        Person expected = PersonProvider.createJohnDowPerson();
        assertThat(johnDowPerson, samePropertyValuesAs(expected, "id"));
    }

    @Test
    public void beansHamcrestTest3() {
        Person johnDowPerson = PersonProvider.createJohnDowPerson();
        Person expected = PersonProvider.createJohnDowPerson();
        expected.setFirstName("Jane");
        assertThat(johnDowPerson, samePropertyValuesAs(expected, "id"));
    }

    @Test
    public void beansHamcrestTest4() {
        Person johnDowPerson = PersonProvider.createJohnDowPerson();
        Person expected = PersonProvider.createJohnDowPerson();
        expected.setFirstName("Jane");
        expected.setDateOfBirth("1991-06-19");
        assertThat(johnDowPerson, samePropertyValuesAs(expected, "id"));
    }
}
