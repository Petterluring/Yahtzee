package com.scoretable;

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
    private static final int BONUSINDEX = 6;
    /**
     * The players column. The column consists of 16 rows each containing
     * the point of a certatin pattern, but where 1 of them is bonus points.
     */
    private int[] column;
    /**
     * This hashmap maps the different patterns and the bonus point to an index.
     * This is used such that the user of the class can refer to an index in the
     * column by inserting a pattern name as a parameter instead of an index number.
     */
    private static final HashMap<String, Integer> indexes = new HashMap<>();
    static {
        indexes.put(PatternNames.ONES, 0);
        indexes.put(PatternNames.TWOS, 1);
        indexes.put(PatternNames.THREES, 2);
        indexes.put(PatternNames.FOURS, 3);
        indexes.put(PatternNames.FIVES, 4);
        indexes.put(PatternNames.SIXES, 5);
        // Bonus index: 6
        indexes.put(PatternNames.PAIR, 7);
        indexes.put(PatternNames.TWOPAIR, 8);
        indexes.put(PatternNames.THREEOFAKIND, 9);
        indexes.put(PatternNames.FOUROFAKIND, 10);
        indexes.put(PatternNames.FULLHOUSE, 11);
        indexes.put(PatternNames.SMALLSTRAIGHT, 12);
        indexes.put(PatternNames.LARGESTRAIGHT, 13);
        indexes.put(PatternNames.YAHTZEE, 14);
        indexes.put(PatternNames.CHANCE, 15);
    }

    public ScoreColumn(int playerID, String playerInitials) {
        this.playerID = playerID;
        this.playerInitials = playerInitials;
        column = initColumn();
    }

    /**
     * Initializes the column by setting all values to -1.
     * -1 is used as a null type for communicating that a pattern have
     * not been used.
     */
    private int[] initColumn() {
        column = new int[16];
        for (int i = 0; i < column.length; i++) {
            column[i] = -1;
        }
        return column;
    }

    public static int getPatternIndex(String pattern) throws IllegalArgumentException {
        Object value = indexes.get(pattern);
        if (value == null) {
            throw new IllegalArgumentException("Pattern does not exist");
        }
        return (int) value;
    }

    public int getColumnElement(int index) throws IllegalArgumentException {
        if (index < 0 || index >= column.length) {
            throw new IllegalArgumentException("Index is out of range");
        }
        return column[index];
    }

    /**
     * Sets a point for a certain pattern. The method consistently checks if the
     * player
     * is eligible for bonus, and assigns a bonus if eligible.
     * 
     * @param pattern - Chosen pattern name
     * @param point   - Chosen point to set
     * @throws IllegalArgumentException - See implementation
     */
    public void setPoint(String pattern, int point) {
        column[getPatternIndex(pattern)] = point;
        if (BONUSINDEX != -1 && onesToSixesUsed()) {
            setBonus(eligiableForBonus());
        }
    }

    /**
     * If the sum of patterns ones to sixes is equal or exceeds 63, then the player
     * are eligable
     * for a bonus of 50 points.
     * 
     * @return - Returns boolean by checking if the sum is equal or exceeds 63.
     */
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

    /**
     * Checks if patterns ones, twos, threes, fours, fives and sixes
     * are all used. We may know this by checking if all these patterns have 
     * a -1 or not in their row. If none of them have -1, then they are all used.
     * @return - True if used, false else
     */
    private boolean onesToSixesUsed() {
        for (int i = 0; i < getBonusIndex(); i++) {
            if (column[i] == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the bonus for a player.
     * 
     * @param eligiable - Is the player eligiable for bonus?
     */
    private void setBonus(boolean eligiable) {
        if (eligiable) {
            column[BONUSINDEX] = 50;
        } else {
            column[BONUSINDEX] = 0;
        }
    }

    /**
     * The bonus is located at index 6 in the column variable.
     * 
     * @return - Returns index.
     */
    public static int getBonusIndex() {
        return BONUSINDEX;
    }

    /**
     * Calculates the grand total by calculating a players column sum.
     * 
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
