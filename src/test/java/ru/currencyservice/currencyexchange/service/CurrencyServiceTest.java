package ru.currencyservice.currencyexchange.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    private static final String CURRENCY = "RUB";

    @Test
    void getResult() {
                Assertions.assertTrue(currencyService.getRateResult(CURRENCY).endsWith("/giphy.gif"));
    }

    @Test
    void getRandomGif() {
        String result = currencyService.getRateResult(CURRENCY);
        String newResult = currencyService.getRateResult(CURRENCY);
        Assertions.assertFalse(result.equalsIgnoreCase(newResult));
    }
}