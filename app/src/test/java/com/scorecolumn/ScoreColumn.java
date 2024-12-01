package com.scorecolumn;

import java.util.HashMap;

/**
 * This class keeps track of the scores of one player. The class
 * is supposed to act as a column in the score table. A player gets their
 * own column in the score table for tracking scores.
 */
public class ScoreColumn {
    private final int playerID;
    private final String playerInitials;
    /**
     * The players column. The column consists of 
     */
    private int[] column;
    private static final HashMap<String, Integer> indexes = new HashMap<>();

    public ScoreColumn(int playerID, String playerInitials) {
        this.playerID = playerID;
        this.playerInitials = playerInitials;
        initColumn();
        if (indexes.size() == 0) {
            initIndexes();
        }
    }

    private static void initIndexes() {

    }

    private void initColumn() {

    }

    private void setPoint(String pattern, int point) {

    }



}
