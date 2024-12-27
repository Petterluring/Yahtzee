package com.scoretable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.player.Player;
import com.scorecolumn.ScoreColumn;

public class ScoreTableTest {
    private final ScoreTable scoreTable = new ScoreTable(
        new Player("John", "Doe"), new Player("Joe", "Ericsson"),
        new Player("Martin", "Ericsson")
    );

    @Test
    void canConstructAttributesProperly() {
        ScoreColumn column = scoreTable.getColumn(0);
        assertEquals(0, column.getPlayerID());
        assertEquals("JD", column.getPlayerInitials());
        column = scoreTable.getColumn(1);
        assertEquals(1, column.getPlayerID());
        assertEquals("JE", column.getPlayerInitials());
        column = scoreTable.getColumn(2);
        assertEquals(2, column.getPlayerID());
        assertEquals("ME", column.getPlayerInitials());
    }

    @Test
    void canSetPointCorrectly() {
        scoreTable.setPoint(0, PatternNames.ones, 3);
        scoreTable.setPoint(1, PatternNames.ones, 3);
        scoreTable.setPoint(2, PatternNames.ones, 3);
        for (ScoreColumn column : scoreTable.getColumns()) {
            assertEquals(3, column.getColumnElement(ScoreColumn.getPatternIndex(PatternNames.ones)));
        }
    }

}
