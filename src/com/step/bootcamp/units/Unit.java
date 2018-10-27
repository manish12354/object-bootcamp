package com.step.bootcamp.units;

import java.util.Objects;

import static com.step.bootcamp.units.UnitTypes.*;


public enum Unit {
    FEET(Constants.A_FOOT_IN_INCH,LENGTH), INCH(Constants.AN_INCH,LENGTH),
    CM(Constants.A_CENTIMETER_IN_INCH,LENGTH), MM(Constants.A_MILLIMETER_IN_INCH,LENGTH),
    GALLON(Constants.A_GALLON_IN_LITER,VOLUME), LITER(Constants.A_LITER,VOLUME),
    KG(Constants.A_KILOGRAM,WEIGHT), TON(Constants.A_TON_IN_KILOGRAM,WEIGHT),
    GM(Constants.A_GRAM_IN_KILOGRAM,WEIGHT),
    CELSIUS(Constants.A_CELSIUS,0,TEMPERATURE),
    FAHRENHEIT(Constants.A_FAHRENHEIT_IN_CELSIUS,32,TEMPERATURE);

    private final double valueInBaseUnit;
    private final double offsetValue;
    private final UnitTypes type;

    Unit(double valueInBaseUnit,double offsetValue,UnitTypes type) {
        this.valueInBaseUnit = valueInBaseUnit;
        this.offsetValue = offsetValue;
        this.type = type;
    }

    Unit(double valueInBaseUnit, UnitTypes type) {
        this(valueInBaseUnit,0,type);
    }

    private double toBaseUnit(double value) {
        return (double) Math.round((value-offsetValue) * valueInBaseUnit*100)/100;
    }

    public boolean isNotSameType(Unit unit) {
        return this.type != unit.type;
    }

    public int hash(double value) {
        return Objects.hash(toBaseUnit(value),type);
    }

    public double toUnit(Unit unit, double value) throws IncompatibleUnitTypeException {
        if (isNotSameType(unit)) throw new IncompatibleUnitTypeException("Cannot convert quantities of different type!");
        return toBaseUnit(value)/unit.valueInBaseUnit + unit.offsetValue;
    }

    private static class Constants {
        private static final int A_FOOT_IN_INCH = 12;
        private static final int AN_INCH = 1;
        private static final double A_CENTIMETER_IN_INCH = 0.4;
        private static final double A_MILLIMETER_IN_INCH = 0.04;
        private static final double A_GALLON_IN_LITER = 3.78;
        private static final int A_LITER = 1;
        private static final int A_KILOGRAM = 1;
        private static final int A_TON_IN_KILOGRAM = 1000;
        private static final double A_GRAM_IN_KILOGRAM = 0.001;
        private static final double A_CELSIUS = 1d;
        private static final double A_FAHRENHEIT_IN_CELSIUS = 5d/9d;
    }
}