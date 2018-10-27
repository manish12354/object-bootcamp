package com.step.bootcamp.units;

import static com.step.bootcamp.units.Unit.*;

public class Quantities {

    public static class Length {
        public static ArithmeticMeasurement inInches(double valueInInches) {
            return new ArithmeticMeasurement(valueInInches, INCH);
        }

        public static ArithmeticMeasurement inFeet(double valueInFeet) {
            return new ArithmeticMeasurement(valueInFeet, FEET);
        }

        public static ArithmeticMeasurement inCentimeters(double value) {
            return new ArithmeticMeasurement(value, CM);
        }

        public static ArithmeticMeasurement inMillimeters(double value) {
            return new ArithmeticMeasurement(value, MM);
        }
    }

    public static class Volume {
        public static ArithmeticMeasurement inGallons(double value) {
            return new ArithmeticMeasurement(value, GALLON);
        }

        public static ArithmeticMeasurement inLiters(double value) {
            return new ArithmeticMeasurement(value, LITER);
        }
    }

    public static class Weight {
        public static ArithmeticMeasurement inKilograms(double value) {
            return new ArithmeticMeasurement(value, KG);
        }

        public static ArithmeticMeasurement inTonnes(double value) {
            return new ArithmeticMeasurement(value, TON);
        }
    }

    public static class Temperature {
        public static Quantity inCelsius(double value) {
            return new Quantity(value, CELSIUS);
        }

        public static Quantity inFahrenheit(double value) {
            return new Quantity(value, FAHRENHEIT);
        }
    }
}