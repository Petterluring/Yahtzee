package com.scoretable;

import com.player.Player;
import com.scorecolumn.ScoreColumn;

/**
 * The score table class keeps track of a players points for the different
 * patterns.
 * It also keeps track of bonus points and grand total of course.
 */
public class ScoreTable {
    private ScoreColumn[] columns;

    public ScoreTable(Player... players) {
        columns = new ScoreColumn[players.length];
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            String firstInitial = String.valueOf(player.getFirstName().charAt(0));
            String secondInitial = String.valueOf(player.getLastName().charAt(0));
            columns[i] = new ScoreColumn(player.getID(), firstInitial + secondInitial);
        }
    }

    /**
     * @param playerID - The index of the column array.
     */
    public void setPoint(int playerID, String pattern, int point) {
        ScoreColumn column = getColumn(playerID);
        column.setPoint(pattern, point);
    }

    public ScoreColumn getColumn(int index) throws IllegalArgumentException {
        if (index < 0 || index >= columns.length) {
            throw new IllegalArgumentException("PlayerID does not exist for this table");
        }
        return columns[index];
    }

    public ScoreColumn[] getColumns() {
        return columns;
    }
}
