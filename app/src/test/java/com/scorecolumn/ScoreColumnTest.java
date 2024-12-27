package com.scorecolumn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.scoretable.ScoreColumn;

class ScoreColumnTest {
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
        assertEquals(0, ScoreColumn.getPatternIndex(PatternNames.ONES));
        assertEquals(1, ScoreColumn.getPatternIndex(PatternNames.TWOS));
        assertEquals(2, ScoreColumn.getPatternIndex(PatternNames.THREES));
        assertEquals(3, ScoreColumn.getPatternIndex(PatternNames.FOURS));
        assertEquals(4, ScoreColumn.getPatternIndex(PatternNames.FIVES));
        assertEquals(5, ScoreColumn.getPatternIndex(PatternNames.SIXES));
        assertEquals(7, ScoreColumn.getPatternIndex(PatternNames.PAIR));
        assertEquals(8, ScoreColumn.getPatternIndex(PatternNames.TWOPAIR));
        assertEquals(9, ScoreColumn.getPatternIndex(PatternNames.THREEOFAKIND));
        assertEquals(10, ScoreColumn.getPatternIndex(PatternNames.FOUROFAKIND));
        assertEquals(11, ScoreColumn.getPatternIndex(PatternNames.FULLHOUSE));
        assertEquals(12, ScoreColumn.getPatternIndex(PatternNames.SMALLSTRAIGHT));
        assertEquals(13, ScoreColumn.getPatternIndex(PatternNames.LARGESTRAIGHT));
        assertEquals(14, ScoreColumn.getPatternIndex(PatternNames.YAHTZEE));
        assertEquals(15, ScoreColumn.getPatternIndex(PatternNames.CHANCE));
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
