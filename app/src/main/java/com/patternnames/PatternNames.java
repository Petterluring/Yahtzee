package com.patternnames;

/**
 * This class defines the names of the different patterns globally.
 * We use this class such that we may be consistent with how
 * we are referring to different patterns throughout the code.
 */
public class PatternNames {
    public final static String ones = "Ones";
    public final static String twos = "Twos";
    public final static String threes = "Threes";
    public final static String fours = "Fours";
    public final static String fives = "Fives";
    public final static String sixes = "Sixes";
    public final static String pair = "Pair";
    public final static String twoPair = "Two Pair";
    public final static String threeOfAKind = "3 of a kind";
    public final static String fourOfAKind = "4 of a kind";
    public final static String fullHouse = "Full House";
    public final static String smallStraight = "Sm Straight";
    public final static String largeStraight = "Lg Straight";
    public final static String yahtzee = "YAHTZEE";
    public final static String chance = "Chance";

    
    public static String[] getNames() {
        return new String[] {
                ones, twos, threes, fours,
                fives, sixes, pair, twoPair,
                threeOfAKind, fourOfAKind, fullHouse,
                smallStraight, largeStraight, yahtzee,
                chance
        };
    }
}
