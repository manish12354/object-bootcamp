package com.step.bootcamp.units;

// Understands to represent comparison of given units

public class Quantity {
    protected final double value;
    protected final Unit unit;

    protected Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity measurement = (Quantity) o;
        try {
            return compareBaseValue(measurement);
        } catch (IncompatibleUnitTypeException e) {
            return false;
        }
    }

    private boolean compareBaseValue(Quantity measurement) throws IncompatibleUnitTypeException {
        if (unit.isNotSameType(measurement.unit)) throw new IncompatibleUnitTypeException("Cannot compare quantities of different type!");
        double baseValue = unit.toUnit(unit,value);
        double otherBaseValue = measurement.unit.toUnit(unit,measurement.value);
        return Double.compare(baseValue,otherBaseValue)==0;
    }

    @Override
    public int hashCode() {
        return unit.hash(value);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}