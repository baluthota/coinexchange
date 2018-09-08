package com.thota.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CoinExchangeImplTest {

    private CoinExchange coinExchange;
    @Before
    public void setUp() throws Exception {
        coinExchange = new CoinExchangeImpl();
    }

    @Test
    public void testexchangeCoinsForAmountForNull() {
        assertNull(coinExchange.exchangeCoinsForAmount(100));
    }

    @Test
    public void testexchangeCoinsForAmountFor40Quarters() {
        Map<String, Integer> denomMap = coinExchange.exchangeCoinsForAmount(10);

        assertTrue(40 == denomMap.get("QUARTER"));
    }
}