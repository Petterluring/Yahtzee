package com.points;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    private static final String faceValueError = "Dice set must contain face values between 1 and 6";

    /**
     * The constructor initializes this class by counting the 
     * occurrences of each faceValue and save it in faceCounter variable.
     * @param dice - Chosen set of dice
     * @throws IllegalArgumentException - Dice set must be of lenght 5
     */
    public Points(int[] dice) throws IllegalArgumentException {
        if (dice.length != 5) {
            throw new IllegalArgumentException("There must be 5 dice.");
        }
        for (int e : dice) {
            if (e < 1 || e > 6) {
                throw new IllegalArgumentException(faceValueError);
            }
        }
        faceCounter = countFaceValues(dice);
    }

    /**
     * Counts the occurences of each face value
     * @param faceValues - Array of face values
     * @return - Returns a hashmap which keeps track of the occurrences
     */
    private HashMap<Integer, Integer> countFaceValues(int[] faceValues) {
        HashMap<Integer, Integer> faceCounter = new HashMap<>();
        for (int faceValue : faceValues) {
            if (faceCounter.containsKey(faceValue)) {
                faceCounter.put(faceValue, faceCounter.get(faceValue) + 1);
            } else {
                faceCounter.put(faceValue, 1);
            }
        }
        return faceCounter;
    }

    /**
     * Calculates and returns the sum of the face values.
     * @return ...
     */
    private int sumOfFaceValues() {
        int sum = 0;
        for (int value : faceCounter.keySet()) {
            sum += value;
        }
        return sum;
    }

    /**
     * Returns the points for ones, twos, ..., sixes. The user chooses which face value the method should
     * return points for.
     * E.g. the faceValues {2, 2, 2, 2, 3} will return 2*4=8 points if the parameter
     * faceValue is set to 2.
     * @param faceValue - Chosen face value.
     * @return - Returns the sum. Returns 0 if parameter faceValue is not found in the faceCounter.
     * @throws IllegalArgumentException - A face value must stay in range between 1 and 6.
     */
    public int onesToSixes(int faceValue) throws IllegalArgumentException {
        if (faceValue < 1 || faceValue > 6) {
            throw new IllegalArgumentException(faceValueError);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = faceCounter.entrySet().iterator();
        do {
            Entry<Integer, Integer> entry = iterator.next();
            if (entry.getKey() == faceValue) {
                return entry.getKey() * entry.getValue();
            }

        } while(iterator.hasNext());

        return 0;
    }


    /**
     * Returns the point of the highest pair in the dice set. 
     * Returns 0 if there is no pair.
     * @return ...
     */
    public int pair() {
        if (faceCounter.size() == 5) {
            return 0;
        }
        int highestFaceValue = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = faceCounter.entrySet().iterator();
        do {
            Entry<Integer, Integer> entry = iterator.next();
            if (entry.getKey() > highestFaceValue && entry.getValue() > 1) {
                highestFaceValue = entry.getKey();
            }
        } while(iterator.hasNext());
        return highestFaceValue * 2;
    }

    public boolean isTwoPair() {
        return true;
    }

    public boolean isThreeOfAKind() {
        return true;
    }

    public boolean isFourOfAkind() {
        return true;
    }

    /**
     * Calculates 
     * @param big
     * @return
     */
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

        return 0;
    }

    public int isYatzhee() {
        if (faceCounter.size() < 5) {
            return 0;
        }
        return 50;
    }

    public int isChance() {
        return sumOfFaceValues();
    }

    public HashMap<Integer, Integer> getFaceCounter() {
        return faceCounter;
    }

}
