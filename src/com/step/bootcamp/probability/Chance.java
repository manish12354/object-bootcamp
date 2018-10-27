package com.step.bootcamp.probability;

import java.util.Objects;

// Understands to represents probability of given event
public class Chance {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance not() {
        return new Chance((double)Math.round((1-probability)*1000)/1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }

    @Override
    public String toString() {
        return "Chance{" +
                "probability=" + probability +
                '}';
    }

    public Chance and(Chance chance) {
        return new Chance(chance.probability*probability);
    }

    public Chance or(Chance anotherChance) {
        return this.not().and(anotherChance.not()).not();
    }
}