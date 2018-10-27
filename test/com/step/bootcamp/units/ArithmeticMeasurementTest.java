package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static com.step.bootcamp.units.Unit.INCH;
import static com.step.bootcamp.units.Unit.LITER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ArithmeticMeasurementTest {
    private ArithmeticMeasurement oneFoot;
    private ArithmeticMeasurement oneGallon;
    private ArithmeticMeasurement oneTonne;
    private ArithmeticMeasurement twoInches;
    private ArithmeticMeasurement fourInches;
    private ArithmeticMeasurement twelveInches;
    private ArithmeticMeasurement twentyFourInches;
    private ArithmeticMeasurement oneKilogram;
    private ArithmeticMeasurement threeInches;
    private ArithmeticMeasurement twoPointFiveCM;

    @Before
    public void setUp() {
        oneFoot = Quantities.Length.inFeet(1d);
        oneGallon = Quantities.Volume.inGallons(1d);
        oneTonne = Quantities.Weight.inTonnes(1d);
        twoInches = Quantities.Length.inInches(2d);
        fourInches = Quantities.Length.inInches(4d);
        twelveInches = Quantities.Length.inInches(12d);
        twentyFourInches = Quantities.Length.inInches(24d);
        oneKilogram = Quantities.Weight.inKilograms(1d);
        threeInches = Quantities.Length.inInches(3d);
        twoPointFiveCM = Quantities.Length.inCentimeters(2.5d);
    }


    @Test
    public void shouldGiveTrueForComparingOneFeetWithOneFeet() {
        ArithmeticMeasurement expectedFoot = Quantities.Length.inFeet(1d);
        ArithmeticMeasurement expectedInches = Quantities.Length.inInches(12d);
        assertEquals(oneFoot, expectedInches);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForComparingZeroFeetWithZeroFeet() {
        ArithmeticMeasurement zeroFoot = Quantities.Length.inFeet(0d);
        ArithmeticMeasurement zeroInch = Quantities.Length.inInches(0d);
        assertEquals(zeroFoot, zeroInch);
    }

    @Test
    public void shouldGiveFalseForComparingOneFeetWithOneInch() {
        ArithmeticMeasurement oneInch = Quantities.Length.inInches(1d);
        assertNotEquals(oneFoot, oneInch);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithTwelveInches() {
        ArithmeticMeasurement twelveInches = Quantities.Length.inInches(12d);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveTrueForComparingTwoInchWithFiveCentimeter() {
        ArithmeticMeasurement twoInches = Quantities.Length.inInches(2);
        ArithmeticMeasurement fiveCentimeter = Quantities.Length.inCentimeters(5);
        assertEquals(twoInches,fiveCentimeter);
    }

    @Test
    public void shouldGiveTrueForComparingOneCentimeterWithTenMillimeter() {
        ArithmeticMeasurement oneCentimeter = Quantities.Length.inCentimeters(1d);
        ArithmeticMeasurement tenMillimeter = Quantities.Length.inMillimeters(10d);
        assertEquals(oneCentimeter,tenMillimeter);
    }

    @Test
    public void shouldGiveTrueFoComparingOneGallonToOneGallon() {
        ArithmeticMeasurement anotherGallon = Quantities.Volume.inGallons(1d);
        assertEquals(oneGallon,anotherGallon);
    }

    @Test
    public void shouldGiveTrueForComparingOneGallonWithThreePointSevenEightLiters() {
        ArithmeticMeasurement threePointSevenEightLiters = Quantities.Volume.inLiters(3.78d);
        assertEquals(oneGallon,threePointSevenEightLiters);
    }

    @Test
    public void shouldGiveTrueFoComparingOneTonneToOneTonne() {
        ArithmeticMeasurement anotherTonne = Quantities.Weight.inTonnes(1d);
        assertEquals(oneTonne,anotherTonne);
    }

    @Test
    public void shouldGiveTrueForComparingOneTonneWithThousandKilograms() {
        ArithmeticMeasurement thousandKilograms = Quantities.Weight.inKilograms(1000d);
        assertEquals(oneTonne,thousandKilograms);
    }

    @Test
    public void shouldThrowInvalidUnitComparisonExceptionForComparingOneKilogramWithOneInch() {
        ArithmeticMeasurement oneInch = Quantities.Length.inInches(1d);
        assertNotEquals(oneInch.hashCode(),oneKilogram.hashCode());
        assertNotEquals(oneInch, oneKilogram);
    }

    @Test
    public void shouldGiveFourInchesForAddingTwoInchAndTwoInch() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement anotherTwoInches = Quantities.Length.inInches(2d);
        assertEquals(twoInches.add(anotherTwoInches), fourInches);
    }

    @Test
    public void shouldNotGiveFourInchesForAddingTwoInchAndFourInch() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement fourKilograms = Quantities.Weight.inKilograms(4d);
        ArithmeticMeasurement unexpectedAddition = twoInches.add(fourInches);
        assertNotEquals(unexpectedAddition,fourKilograms);
        assertNotEquals(unexpectedAddition.hashCode(), fourKilograms.hashCode());
    }

    @Test
    public void shouldGiveTwoFeetForAddingOneFeetAndTwelveInches() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = oneFoot.add(twelveInches).toUnit(INCH);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveTwentyFourInchesForAddingTwelveInchesAndOneFeet() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twelveInches.add(oneFoot);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoInchesAndTwoPointFiveCM() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twoInches.add(twoPointFiveCM);
        assertEquals(expectedAddition, threeInches);
        assertEquals(expectedAddition.hashCode(), threeInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoPointFiveCMAndTwoInches() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twoPointFiveCM.add(twoInches).toUnit(INCH);
        assertEquals(expectedAddition,threeInches);
        assertEquals(expectedAddition.hashCode(),threeInches.hashCode());
        assertEquals(expectedAddition.toString(),threeInches.toString());
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void shouldThrowExceptionForAddingDifferentUnits() throws IncompatibleUnitTypeException {
        twoInches.add(oneKilogram);
    }

    @Test
    public void shouldGiveThirteenInchesForAddingOneFootAndTwoPointFiveCM() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement thirteenInches = Quantities.Length.inInches(13d);
        ArithmeticMeasurement expectedAddition = oneFoot.add(twoPointFiveCM);
        assertEquals(expectedAddition,thirteenInches);
        assertEquals(expectedAddition.toUnit(INCH).hashCode(),thirteenInches.hashCode());
        assertEquals(expectedAddition.toUnit(INCH).toString(),thirteenInches.toString());
    }

    @Test
    public void shouldReturnFalseForComparingUnitsOfDifferentTypes() {
        assertNotEquals(twoInches,oneKilogram);
    }

    @Test
    public void shouldGiveFourPointSevenEightLitersForAddingOneGallonAndOneLiter() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement oneLiter = Quantities.Volume.inLiters(1d);
        ArithmeticMeasurement fourPointSevenEightLiters = Quantities.Volume.inLiters(4.78d);
        ArithmeticMeasurement expectedAddition = oneGallon.add(oneLiter).toUnit(LITER);
        assertEquals(expectedAddition,fourPointSevenEightLiters);
        assertEquals(expectedAddition.toString(),fourPointSevenEightLiters.toString());
    }
}
