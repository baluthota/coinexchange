package com.thota.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinExchangeImpl implements CoinExchange {

    private static Map<String, Integer> numberOfCoinsMap = new LinkedHashMap<>();

    private static Map<String, Double> coinValue = new HashMap<>();

    private static int numberOfCoins = 100;

    static {
        coinValue.put("WHATEVER", 0.75);
        coinValue.put("QUARTER", 0.25);
        coinValue.put("DIME", 0.1);
        coinValue.put("NICKEL", 0.05);
        coinValue.put("CENT", 0.01);
    }

    public CoinExchangeImpl(){
        initializeMap();
    }

    @Override
    public Map<String, Integer> exchangeCoinsForAmount(double amount) {

        double tempAmount = amount;
        Map<String, Integer> denomMapForAmount = new LinkedHashMap<>();

        for (String denom : numberOfCoinsMap.keySet()) {

            int denomAvail = numberOfCoinsMap.get(denom);

            if (tempAmount > 0 && denomAvail > 0) {

                double denomNeeded = Math.floor(tempAmount / coinValue.get(denom));
                //double rem = tempAmount % coinValue.get(denom);
                if (denomNeeded <= denomAvail) {
                    tempAmount = tempAmount - denomNeeded * coinValue.get(denom);
                    denomMapForAmount.put(denom, (int) denomNeeded);
                    numberOfCoinsMap.put(denom, denomAvail - (int) denomNeeded);
                    //return denomMapForAmount;
                }

                if (denomNeeded >= denomAvail) {
                    tempAmount = tempAmount - denomAvail * coinValue.get(denom);
                    denomMapForAmount.put(denom, denomAvail);
                    numberOfCoinsMap.put(denom, 0);
                }

//                String tempStr = String.valueOf(tempAmount);
//                if(tempStr.substring(tempStr.indexOf(".")).length() > 3) {
//                    tempStr = tempStr.substring(0, tempStr.indexOf(".")+2);
//                    tempAmount = Double.parseDouble(tempStr);
//                }
              //  tempAmount = tempAmount - numberOfCoinsMap.get(denom) * coinValue.get(denom);
                tempAmount = Math.floor(tempAmount * 10000)/10000;
            }
        }
        if(tempAmount == 0)  return denomMapForAmount;
        if (tempAmount > 0) {
            return null;
        }
        return denomMapForAmount;
    }


    private static void initializeMap() {
        numberOfCoinsMap.put("WHATEVER", 75);
        numberOfCoinsMap.put("QUARTER", numberOfCoins);
        numberOfCoinsMap.put("DIME", numberOfCoins);
        numberOfCoinsMap.put("NICKEL", numberOfCoins);
        numberOfCoinsMap.put("CENT", numberOfCoins);


    }
}
