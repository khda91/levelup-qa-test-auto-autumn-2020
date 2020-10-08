package ru.levelup.qa.at.unit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class PersonProvider {

    public static Person createRandomPerson() {
        return new Person(RandomUtils.nextLong(),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.random(8));
    }

    public static Person createJohnDowPerson() {
        return new Person(RandomUtils.nextLong(), "John", "Dow", "2020-07-15");
    }
}
