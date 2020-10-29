package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class ConverterServiceImpl implements ConverterService {

    private CurrencyConverterService currencyConverterService;

    public ConverterServiceImpl(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    @Override
    public BigDecimal convert(BigDecimal amount) {
        return currencyConverterService.convert(amount);
    }
}
