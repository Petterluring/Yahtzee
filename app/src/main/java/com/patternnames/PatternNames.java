package com.patternnames;

/**
 * This class defines the names of the different patterns globally.
 * We use this class such that we may be consistent with how
 * we are referring to different patterns throughout the code.
 */
public class PatternNames {
    public final static String ONES = "Ones";
    public final static String TWOS = "Twos";
    public final static String THREES = "Threes";
    public final static String FOURS = "Fours";
    public final static String FIVES = "Fives";
    public final static String SIXES = "Sixes";
    public final static String PAIR = "Pair";
    public final static String TWOPAIR = "Two Pair";
    public final static String THREEOFAKIND = "3 of a kind";
    public final static String FOUROFAKIND = "4 of a kind";
    public final static String FULLHOUSE = "Full House";
    public final static String SMALLSTRAIGHT = "Sm Straight";
    public final static String LARGESTRAIGHT = "Lg Straight";
    public final static String YAHTZEE = "YAHTZEE";
    public final static String CHANCE = "Chance";

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
