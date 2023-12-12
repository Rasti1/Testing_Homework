package org.example.app;

import org.example.app.service.BonusService;

import java.util.Locale;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    private static final String CURRENCY = "EUR";

    public static void main(String[] args) {
        getOutput(getBonus(getData()));
    }

    static double getData() {
        scanner.useLocale(Locale.ENGLISH);
        System.out.print("Enter sales, " + CURRENCY + ": ");
        return scanner.nextDouble();
    }

    static String getBonus(double sales) {
        return new BonusService().getRes(sales);
    }

    static void getOutput(String output) {
        scanner.close();
        System.out.println("Bonus is " + CURRENCY + " " + output);
    }
}
