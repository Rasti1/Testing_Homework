package org.example.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.example.app.utils.Rounder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusServiceTest {
    private BonusService service;

    @BeforeEach
    void setUp(){
        service = new BonusService();
    }

    @Test
    void test_Calculate_Bonus() {
        double sales = 1000.0;
        double bonus = service.calcBonus(sales);
        assertEquals(100.0, bonus);
    }

    @Test
    @DisplayName("Test for unexpected results.")
    void test_Calculate_Bonus_Unexpected_Results(){
        double sales = 500.0;
        double bonus = service.calcBonus(sales);
        assertNotEquals(100.0, bonus);
    }

    @Test
    @DisplayName("Correct rounding test.")
    void testRoundValue() {
        double sales = 1234.5678;
        String expectedFormattedValue = "1234,57";
        String actualFormattedValue = Rounder.roundValue(sales);
        assertEquals (expectedFormattedValue, actualFormattedValue);
    }

    @Test
    @DisplayName("Incorrect rounding test.")
    void wrong_Rounding(){
        double sales = 1000.3427;
        assertNotEquals("1000,342", service.calcBonus(sales));
    }

    @AfterEach
    void tearDown(){
        service = null;
    }

}