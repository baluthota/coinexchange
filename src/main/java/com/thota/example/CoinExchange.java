package com.thota.example;

import java.util.Map;

public interface CoinExchange {

    Map<String, Integer> exchangeCoinsForAmount(double amount);
}
