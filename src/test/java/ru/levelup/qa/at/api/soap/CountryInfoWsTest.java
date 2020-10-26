package ru.levelup.qa.at.api.soap;

import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CountryInfoWsTest {

    @Test
    public void countryCapitalTest() {
        CountryInfoService cis = new CountryInfoService();
        String actualCapitalName = cis.getCountryInfoServiceSoap().capitalCity("RUS");
        System.out.println(actualCapitalName);
        assertThat(actualCapitalName, equalTo("Moscow"));
    }
}
