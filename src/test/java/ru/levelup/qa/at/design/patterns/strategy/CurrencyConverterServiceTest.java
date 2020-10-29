package ru.levelup.qa.at.design.patterns.strategy;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CurrencyConverterServiceTest {

    @Test
    public void testDollarToRub() {
        ConverterService converterService = new ConverterServiceImpl(new DollarToRubCurrencyConverterService());
        BigDecimal expected = converterService.convert(new BigDecimal(2));
        assertThat(expected, equalTo(new BigDecimal(164)));
    }
}
