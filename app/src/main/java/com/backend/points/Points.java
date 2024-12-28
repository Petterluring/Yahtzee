package com.backend.points;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class calculates the different points for a given pattern.
 * Remark that a pattern can have different amount of points depending on
 * the face values.
 */
public class Points {
    /**
     * Keeps track of the occurences of each face value for a set
     * of 5 dice.
     */
    private HashMap<Integer, Integer> faceCounter;
    private static final String FACEVALUEERROR = "Dice set must contain face values between 1 and 6";

    /**
     * The constructor initializes this class by counting the
     * occurrences of each faceValue and save it in faceCounter variable.
     * 
     * @param faceValues - Chosen set of dice
     */
    public Points(int[] faceValues) throws IllegalArgumentException {
        if (faceValues.length != 5) {
            throw new IllegalArgumentException("There must be 5 dice.");
        }
        for (int e : faceValues) {
            if (e < 1 || e > 6) {
                throw new IllegalArgumentException(FACEVALUEERROR);
            }
        }
        faceCounter = countFaceValues(faceValues);
    }

    /**
     * Counts the occurences of each face value
     * @param faceValues - Array of face values
     * @return - Returns a hashmap which keeps track of the occurrences
     */
    private HashMap<Integer, Integer> countFaceValues(int[] faceValues) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int faceValue : faceValues) {
            if (counter.containsKey(faceValue)) {
                counter.put(faceValue, counter.get(faceValue) + 1);
            } else {
                counter.put(faceValue, 1);
            }
        }
        return counter;
    }


    private int sumOfFaceValues() {
        int sum = 0;
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }

    /**
     * Returns the points for ones, twos, ..., sixes. The user chooses which face
     * value the method should return points for.
     * E.g. the faceValues {2, 2, 2, 2, 3} will return 2*4=8 points if the parameter
     * faceValue is set to 2.
     * 
     * @param faceValue - Chosen face value.
     * @return - Returns the point. Returns 0 if parameter faceValue is not found in
     *         the faceCounter.
     */
    public int onesToSixes(int faceValue) throws IllegalArgumentException {
        if (faceValue < 1 || faceValue > 6) {
            throw new IllegalArgumentException(FACEVALUEERROR);
        }
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            int key = entry.getKey();
            if (key == faceValue) {
                return key * entry.getValue();
            }
        }
        return 0;
    }


    /*
     * The following methods calculates the points for the different patterns. 
     * A certain pattern may have different point ranges depending on the face values. 
     * The following methods will always calculate the best possible point for a certain pattern. 
     * E.g, if the face values are {1, 2, 2, 3, 3}, then the pair() method will return the highest
     * pair since that pair will be the highest point, i.e 3*2=6.
     * 
     * BEGIN
     */

    public int pair() {
        if (faceCounter.size() == 5) {
            return 0;
        }
        int highestFaceValue = 0;
        for(Entry<Integer, Integer> entry: faceCounter.entrySet()) {
            int key = entry.getKey();
            if (key > highestFaceValue && entry.getValue() > 1) {
                highestFaceValue = key;
            }
        }
        return highestFaceValue * 2;
    }

    public int twoPair() {
        if (faceCounter.size() == 1 || faceCounter.size() >= 4) {
            return 0;
        }
        int sum = 0;
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            int value = entry.getValue();
            if (value == 2 || value == 3) {
                sum += entry.getKey() * 2;
            }
        }
        return sum;
    }

    public int threeOfAKind() {
        if (faceCounter.size() >= 4) {
            return 0;
        }
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            if (entry.getValue() >= 3) {
                return entry.getKey() * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        if (faceCounter.size() > 2) {
            return 0;
        }
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            if (entry.getValue() >= 4) {
                return entry.getKey() * 4;
            }
        }
        return 0;
    }

    public int straight(boolean big) {
        if (faceCounter.size() != 5) {
            return 0;
        }
        int point = 15;
        if (big) {
            point = 20;
        }
        int sum = sumOfFaceValues();
        if (sum != point) {
            return 0;
        }
        return point;
    }

    public int fullHouse() {
        if (faceCounter.size() != 2) {
            return 0;
        }
        for (Entry<Integer, Integer> entry : faceCounter.entrySet()) {
            int value = entry.getValue();
            if (value == 2 || value == 3) {
                return sumOfFaceValues();
            }
        }
        return 0;
    }

    public int yahtzee() {
        if (faceCounter.size() != 1) {
            return 0;
        }
        return 50;
    }

    public int chance() {
        return sumOfFaceValues();
    }
    /*
     * END
     */

    /**
     * Returns the hashmap contain the count of the different face values
     * @return - ...
     */
    public HashMap<Integer, Integer> getFaceCounter() {
        return faceCounter;
    }
}
