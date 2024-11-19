package com.patterns;

import java.util.HashMap;

import com.die.Die;

/**
 * The Patterns class identifies which patterns a set of dice have.
 */
public class Patterns {
    private HashMap<Integer, Integer> faceCounter;

    /**
     * The constructor initializes this class by counting the 
     * occurrences of each faceValue and save it in faceCounter variable.
     * @param dice - Chosen set of dice
     * @throws IllegalArgumentException - Dice set must be of lenght 5
     */
    public Patterns(Die[] dice) throws IllegalArgumentException {
        if (dice.length != 5) {
            throw new IllegalArgumentException("There must be 5 dice.");
        }
        faceCounter = countFaceValues(dice);
    }

    private HashMap<Integer, Integer> countFaceValues(Die[] dice) {
        HashMap<Integer, Integer> faceCounter = new HashMap<>();
        for (Die die : dice) {
            int faceValue = die.getFaceValue();
            if (faceCounter.containsKey(faceValue)) {
                faceCounter.put(faceValue, faceCounter.get(faceValue) + 1);
            } else {
                faceCounter.put(faceValue, 1);
            }
        }
        return faceCounter;
    }


    public boolean isOnesToSixes(int faceValue) {
        return true;
    }

    public boolean isPair() {
        int size = faceCounter.size();
        if (size >= 1 && size <= 4) {
            return true;
        }
        return false;
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

    public boolean isSmallStraight() {
        return true;
    }

    public boolean isLargeStraight() {
        return true;
    }

    public boolean isFullHouse() {
        return true;
    }

    public boolean isYatzhee() {
        return faceCounter.size() == 1;
    }

    public boolean isChance() {
        return true;
    }

}
