package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {

    private Quantity hundredCelsius;
    private Quantity twoHundredTwelveFahrenheit;

    @Before
    public void setUp() {
        hundredCelsius = Quantities.Temperature.inCelsius(100d);
        twoHundredTwelveFahrenheit = Quantities.Temperature.inFahrenheit(212d);
    }

    @Test
    public void shouldGiveTwoHundredTwelveFahrenheitForHundredCelsius() {
        assertEquals(hundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void shouldGiveThreeHundredNinetyTwoFahrenheitForTwoHundredCelsius() {
        Quantity threeHundredNinetyTwoFahrenheit = Quantities.Temperature.inFahrenheit(392d);
        Quantity twoHundredCelsius = Quantities.Temperature.inCelsius(200d);
        assertEquals(twoHundredCelsius,threeHundredNinetyTwoFahrenheit);
    }
}