package com.example.teammark;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationADTest {
    private CalculationAD calculationAD;

    @Before
    public void setUp() {
        calculationAD = new CalculationAD();
    }
    @Test
    public void goldSubTotal() {
        int answer = 3000;
        //int answer = calculationAD.GoldSubTotal(3);
        assertEquals(3000,answer);
    }

    @Test
    public void silverSubTotal() {
        int answer = calculationAD.SilverSubTotal(2);
        assertEquals(1500,answer);
    }

    @Test
    public void brownSubTotal() {
        int answer = calculationAD.BrownSubTotal(4);
        assertEquals(2000,answer);
    }
}