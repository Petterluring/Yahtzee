package com.scorecolumn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.scorecolumn.ScoreColumn;

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
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.ones), 0);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.twos), 1);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.threes), 2);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.fours), 3);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.fives), 4);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.sixes), 5);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.pair), 7);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.twoPair), 8);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.threeOfAKind), 9);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.fourOfAKind), 10);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.fullHouse), 11);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.smallStraight), 12);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.largeStraight), 13);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.yahtzee), 14);
        assertEquals(ScoreColumn.getPatternIndex(PatternNames.chance), 15);
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
        scoreColumn.setPoint(PatternNames.ones, 18);
        scoreColumn.setPoint(PatternNames.twos, 18);
        scoreColumn.setPoint(PatternNames.threes, 18);
        scoreColumn.setPoint(PatternNames.fours, 18);
        scoreColumn.setPoint(PatternNames.fives, 18);
        scoreColumn.setPoint(PatternNames.sixes, 18);
        assertEquals(50, scoreColumn.getColumnElement(ScoreColumn.getBonusIndex()));
        ScoreColumn scoreColumn = new ScoreColumn(1, "PG");
        scoreColumn.setPoint(PatternNames.ones, 0);
        scoreColumn.setPoint(PatternNames.twos, 0);
        scoreColumn.setPoint(PatternNames.threes, 0);
        scoreColumn.setPoint(PatternNames.fours, 0);
        scoreColumn.setPoint(PatternNames.fives, 0);
        scoreColumn.setPoint(PatternNames.sixes, 0);
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
