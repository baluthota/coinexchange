package com.thota.example;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;


public class CoinApp
{
    public static void main( String[] args )
    {
        CoinExchange coinExchange = new CoinExchangeImpl();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter amount : ");
        try {
            int amount = reader.nextInt();
            while (amount > 0) {
                Map<String, Integer> denomMap = coinExchange.exchangeCoinsForAmount(amount);
                if (denomMap == null) {
                    System.out.println(" There are not enough coins to dispense the change, exiting the system");
                    System.exit(0);
                } else {
                    System.out.printf("Coin Exchange For Amount $%d ==> %s ", amount, denomMap.entrySet()
                            .stream()
                            .map(Object::toString)
                            .collect(joining(" & ")));
                    System.out.println();
                }
                reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("Enter amount : ");
                amount = reader.nextInt();

            }
        }catch (InputMismatchException ne) {
            System.out.println("Enter only whole amount, ex: 10, 15,22");
            System.exit(-1);
        } finally {

            reader.close();
        }
    }
}
