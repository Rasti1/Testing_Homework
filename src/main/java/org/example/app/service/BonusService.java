package org.example.app.service;

import org.example.app.utils.Rounder;

public class BonusService {

    private static final double BONUS_RATE = 10;

    public String getRes(double sales) {
        if (sales > 0.0) {
            return Rounder.roundValue(calcBonus(sales));
        } else {
            return "Incorrect value!";
        }
    }

    public double calcBonus(double sales) {
        return sales * BONUS_RATE / 100;
    }
}
