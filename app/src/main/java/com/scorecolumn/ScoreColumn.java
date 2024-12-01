package com.scorecolumn;

import java.util.HashMap;

import com.patternnames.PatternNames;

/**
 * This class keeps track of the scores of one player. The class
 * is supposed to act as a column in the score table. A player gets their
 * own column in the score table for tracking scores. A score column could have 
 * the following look: 
 * 
 */
public class ScoreColumn {
    private final int playerID;
    private final String playerInitials;
    /**
     * The players column. The column consists of 16 rows each containing
     * the point of a certatin pattern, but where 1 of them is bonus points.
     */
    private int[] column;
    /**
     * This hashmap maps the different patterns and bonus point row to an index. 
     * This is needed such that the user of the class can refer to an index in the 
     * column by pattern name instead of a number.
     */
    private static final HashMap<String, Integer> indexes = new HashMap<>();

    public ScoreColumn(int playerID, String playerInitials) {
        this.playerID = playerID;
        this.playerInitials = playerInitials;
        initColumn();
        if (indexes.size() == 0) {
            initIndexes();
        }
    }

    /**
     * Assigns appropriate indexes for the given patterns.
     */
    private static void initIndexes() {
        indexes.put(PatternNames.ones, 0);
        indexes.put(PatternNames.twos, 1);
        indexes.put(PatternNames.threes, 2);
        indexes.put(PatternNames.fours, 3);
        indexes.put(PatternNames.fives, 4);
        indexes.put(PatternNames.sixes, 5);
        // Bonus index: 6
        indexes.put(PatternNames.pair, 7);
        indexes.put(PatternNames.twoPair, 8);
        indexes.put(PatternNames.threeOfAKind, 9);
        indexes.put(PatternNames.fourOfAKind, 10);
        indexes.put(PatternNames.fullHouse, 11);
        indexes.put(PatternNames.smallStraight, 12);
        indexes.put(PatternNames.largeStraight, 13);
        indexes.put(PatternNames.yahtzee, 14);
        indexes.put(PatternNames.chance, 15);
    }

    /**
     * Initializes the column by setting all values to -1. 
     * The -1 is used for communicating that a pattern have
     * not been used yet.
     */
    private void initColumn() {
        column = new int[16];
        for (int i = 0; i < column.length; i++) {
            column[i] = -1;
        }
    }

    public void setPoint(String pattern, int point) {

    }

    private boolean eligiableForBonus() {
        int sum = 0;
        for (int i = 0; i < getBonusIndex(); i++) {
            int point = column[i];
            if (point != -1) {
                sum += point;
            }
        }
        return sum >= 63;
    }

    private int getBonusIndex() {
        return 6;
    }

    private void setBonus(boolean eligiable) {
        if (eligiable) {
            column[getBonusIndex()] = 50;
        } else {
            column[getBonusIndex()] = 0;
        }
    }


    /**
     * Calculates the grand total by calculating a players column sum.
     * @return - ...
     */
    public int getGrandTotal() {
        int sum = 0;
        for (int point : column) {
            if (point != -1) {
                sum += point;
            }
        }
        return sum;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerInitials() {
        return playerInitials;
    }



}
