package com.step.bootcamp.units;

public class ArithmeticMeasurement extends Quantity {
    ArithmeticMeasurement(double value, Unit unit) {
        super(value, unit);
    }

    public ArithmeticMeasurement add(ArithmeticMeasurement other) throws IncompatibleUnitTypeException {
        if (unit.isNotSameType(other.unit)) throw new IncompatibleUnitTypeException("Cannot add quantities of different type!");
        double otherBaseValue = other.unit.toUnit(unit,other.value);
        double valueInBaseUnit = value + otherBaseValue;
        return new ArithmeticMeasurement(valueInBaseUnit, unit);
    }

    public ArithmeticMeasurement toUnit(Unit standardUnit) throws IncompatibleUnitTypeException {
        double result = unit.toUnit(standardUnit,value);
        return new ArithmeticMeasurement(result,standardUnit);
    }
}
