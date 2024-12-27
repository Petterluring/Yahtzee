package com.scorecolumn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;

public class ScoreColumnTest {
    private final ScoreColumn scoreColumn = new ScoreColumn(1, "PG");

    @Test
    void constructurAssignsVariablesCorrectly() {
        assertEquals("PG", scoreColumn.getPlayerInitials());
        assertEquals(1, scoreColumn.getPlayerID());
        for (int i = 0; i < 16; i++) {
            assertEquals(-1, scoreColumn.getColumnElement(i));
        }
    }

    /**
     * Refers to the mapping of pattern names to indexes
     */
    @Test
    void indexesIsAssignedCorrectly() {
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.ONES), 0);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.TWOS), 1);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.THREES), 2);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.FOURS), 3);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.FIVES), 4);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.SIXES), 5);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.PAIR), 7);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.TWOPAIR), 8);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.THREEOFAKIND), 9);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.FOUROFAKIND), 10);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.FULLHOUSE), 11);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.SMALLSTRAIGHT), 12);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.LARGESTRAIGHT), 13);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.YAHTZEE), 14);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.CHANCE), 15);
    }

    @Test
    void getPatternIndexCanThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ScoreColumn.getPatternIndex("wefewf");
        });
    }

    @Test
    void getColumnElementCanThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            scoreColumn.getColumnElement(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            scoreColumn.getColumnElement(17);
        });
    }

    @Test
    void getBonusIndexReturnsCorrectIndex() {
        assertEquals(6, ScoreColumn.getBonusIndex());
    }

    @Test
    void canSetPointCorrectly() {
        String[] patterns = PatternNames.getNames();
        for (String pattern : patterns) {
            scoreColumn.setPoint(pattern, 1);
            assertEquals(1, scoreColumn.getColumnElement(ScoreColumn.getPatternIndex(pattern)));
        }
    }

    @Test
    void canAssignBonusPointCorrectly() {
        scoreColumn.setPoint(PatternNames.ONES, 18);
        scoreColumn.setPoint(PatternNames.TWOS, 18);
        scoreColumn.setPoint(PatternNames.THREES, 18);
        scoreColumn.setPoint(PatternNames.FOURS, 18);
        scoreColumn.setPoint(PatternNames.FIVES, 18);
        scoreColumn.setPoint(PatternNames.SIXES, 18);
        assertEquals(50, scoreColumn.getColumnElement(ScoreColumn.getBonusIndex()));
        ScoreColumn scoreColumn = new ScoreColumn(1, "PG");
        scoreColumn.setPoint(PatternNames.ONES, 0);
        scoreColumn.setPoint(PatternNames.TWOS, 0);
        scoreColumn.setPoint(PatternNames.THREES, 0);
        scoreColumn.setPoint(PatternNames.FOURS, 0);
        scoreColumn.setPoint(PatternNames.FIVES, 0);
        scoreColumn.setPoint(PatternNames.SIXES, 0);
        assertEquals(0, scoreColumn.getColumnElement(ScoreColumn.getBonusIndex()));
    }

    @Test
    void canReturnCorrectTotal() {
        for (String pattern : PatternNames.getNames()) {
            scoreColumn.setPoint(pattern, 1);
        }
        assertEquals(15, scoreColumn.getGrandTotal());

    }
}
