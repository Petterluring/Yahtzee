package com.patternnames;

/**
 * This class defines the names of the different patterns globally.
 * We use this class such that we may be consistent with how
 * we are referring to different patterns throughout the code.
 */
public class PatternNames {
    public static final String ONES = "Ones";
    public static final String TWOS = "Twos";
    public static final String THREES = "Threes";
    public static final String FOURS = "Fours";
    public static final String FIVES = "Fives";
    public static final String SIXES = "Sixes";
    public static final String PAIR = "Pair";
    public static final String TWOPAIR = "Two Pair";
    public static final String THREEOFAKIND = "3 of a kind";
    public static final String FOUROFAKIND = "4 of a kind";
    public static final String FULLHOUSE = "Full House";
    public static final String SMALLSTRAIGHT = "Sm Straight";
    public static final String LARGESTRAIGHT = "Lg Straight";
    public static final String YAHTZEE = "YAHTZEE";
    public static final String CHANCE = "Chance";

    private PatternNames() {}
    
    public static String[] getNames() {
        return new String[] {
                ONES, TWOS, THREES, FOURS,
                FIVES, SIXES, PAIR, TWOPAIR,
                THREEOFAKIND, FOUROFAKIND, FULLHOUSE,
                SMALLSTRAIGHT, LARGESTRAIGHT, YAHTZEE,
                CHANCE
        };
    }
}
