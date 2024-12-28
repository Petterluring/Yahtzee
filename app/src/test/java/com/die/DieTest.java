package com.die;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DieTest {
    private final Die die = new Die(6);

    @Test
    void dieCanBeInitialized() {
        int faceValue = die.getFaceValue();
        assertTrue(faceValue >= 1 && faceValue <= 6);
    }

    @Test
    void dieHasCorrectAmountOfSides() {
        assertEquals(6, die.getSides());
    }

    @Test
    void dieCanBeRoled() {
        int iterations = 1_000_000;
        int[] counts = new int[6];
        for (int i = 0; i < iterations; i++) {
            counts[die.roll() - 1] += 1;
        }
        for (int e : counts) {
            assertNotEquals(0, e);
        }
    }

    @Test
    void canGetFaceValue() {
        int faceValue = die.getFaceValue();
        assertTrue(faceValue >= 1 && faceValue <= 6);
    }
}
