package com.die;

import java.util.Random;

/**
 * The purpose of this class is to capture the behaviour
 * a standard die.
 */
public class Die {
    /**
     * The current face value of the die
     */
    private int faceValue;

    /**
     * Amount of sides on the die
     */
    private final int sides;
    /**
     * Random generator used for rolling the die.
     */
    private static final Random random = new Random();

    /**
     * Constructor starts off by rolling the die such
     * that the die is initialized.
     */
    public Die(int sides) throws IllegalArgumentException {
        if (sides <= 0) {
            throw new IllegalArgumentException("A die must have at least one side");
        }
        this.sides = sides;
        role();
    }

    /**
     * Roles the die
     * 
     * @return - Returns the face value from the role
     */
    public int role() {
        faceValue = random.nextInt(sides) + 1;
        return faceValue;
    }

    /**
     * Returns the amount of sides on the die
     * 
     * @return - ...
     */
    public int getSides() {
        return sides;
    }

    /**
     * Returns the current faceValue
     * 
     * @return - ...
     */
    public int getFaceValue() {
        return faceValue;
    }
}
