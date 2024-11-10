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
     * Random generator used for rolling the die.
     */
    private static Random random = new Random();


    /**
     * Constructor starts off by rolling the die such 
     * that the die is initialized.
     */
    public Die() {
        role();
    }

    /**
     * Roles the die
     * @return - Returns the face value from the role
     */
    public int role() {
       faceValue = random.nextInt(6) + 1;
       return faceValue;
    }

    /**
     * Returns the current faceValue
     * @return - ...
     */
    public int getFaceValue() {
        return faceValue;
    }
}
