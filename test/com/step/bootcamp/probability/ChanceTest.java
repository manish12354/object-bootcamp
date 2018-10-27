package com.step.bootcamp.probability;

import com.step.bootcamp.probability.Chance;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Ensures correctness of chance
public class ChanceTest {

    private Chance chance;

    @Before
    public void setUp() {
        chance = new Chance(0.5d);
    }

    @Test
    public void chanceOfNotGettingTailWhenCoinIsFlipped() {
        assertEquals(chance,new Chance(0.5d));
    }

    @Test
    public void shouldGiveFalseForComparingChanceWithNull() {
        assertNotEquals(chance,null);
    }

    @Test
    public void shouldGiveFalseForComparingChanceWithDifferentClass() {
        assertNotEquals(chance,new Integer(5));
    }

    @Test
    public void shouldGiveTrueForComparingChanceWithItself() {
        assertEquals(chance,chance);
    }

    @Test
    public void shouldGiveTrueForReflectiveComparison() {
        Chance chance1 = new Chance(0.5d);
        assertEquals(chance,chance1);
        assertEquals(chance1,chance);
    }

    @Test
    public void shouldGiveTrueForTransitiveComparison() {
        Chance chance1 = new Chance(0.5d);
        Chance chance2 = new Chance(0.5d);
        assertEquals(chance1,chance2);
        assertEquals(chance,chance2);
        assertEquals(chance,chance1);
    }

    @Test
    public void shouldGiveTrueForNotGettingProbabilityWithOnePrecisionPoint() {
        assertEquals(new Chance(0.8d).not(),new Chance(0.2d));
    }

    @Test
    public void shouldGiveTrueForNotGettingProbabilityWithTwoPrecisionPoints() {
        assertEquals(new Chance(0.35d).not(),new Chance(0.65d));
    }

    @Test
    public void shouldGiveFalseForWrongProbabilityValues() {
        assertNotEquals(new Chance(0.45d).not(),new Chance(0.64d));
    }

    @Test
    public void shouldGive1By4ForGettingProbabilityOfTailOnBothCoins() {
        Chance chance1 = new Chance(0.5d);
        assertEquals(chance.and(chance1),new Chance(0.25d));
    }

    @Test
    public void shouldGiveProbabilityForTailFromCoinAndFiveFromDiceAndRedCardFromDeckOfCards() {
        Chance coin = new Chance(0.5d);
        Chance dice = new Chance(0.16d);
        Chance card = new Chance(0.5d);
        Chance expected = coin
                .and(dice)
                .and(card);
        assertEquals(expected,new Chance(0.04d));
    }

    @Test
    public void shouldGiveProbabilityForGettingAtLeastOneTail() {
        Chance anotherCoin = new Chance(0.5d);
        assertEquals(chance.or(anotherCoin),new Chance(0.75d));
    }

    @Test
    public void shouldGiveProbabilityOfAtLeastOneSixForTwoDice() {
        Chance dice = new Chance(0.167d);
        Chance anotherDice = new Chance(0.167d);
        assertEquals(dice.or(anotherDice),new Chance(0.306d));
    }
}