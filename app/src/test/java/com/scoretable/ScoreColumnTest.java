package com.scoretable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.scorecolumn.ScoreColumn;

public class ScoreColumnTest {

    @Test
    void constructorAssignsVariablesCorrectly() {
        ScoreColumn scoreColumn = new ScoreColumn(1, "PG");
        assertEquals(1, scoreColumn.getPlayerID());
        assertEquals("PG", scoreColumn.getPlayerInitials());
        for (int i = 0; i < 16; i++) {
            assertEquals(-1, scoreColumn.getColumnElement(i));
        }
    }

    @Test
    void assignsCorrectIndexes() {
        ScoreColumn scoreColumn = new ScoreColumn(1, "PG"); // Only used such that indexes are initialized
        assertEquals(0, ScoreColumn.getPatternIndex(PatternNames.ones));
        assertEquals(1, ScoreColumn.getPatternIndex(PatternNames.twos));
        assertEquals(2, ScoreColumn.getPatternIndex(PatternNames.threes));
        assertEquals(3, ScoreColumn.getPatternIndex(PatternNames.fours));
        assertEquals(4, ScoreColumn.getPatternIndex(PatternNames.fives));
        assertEquals(5, ScoreColumn.getPatternIndex(PatternNames.sixes));
        assertEquals(7, ScoreColumn.getPatternIndex(PatternNames.pair));
        assertEquals(8, ScoreColumn.getPatternIndex(PatternNames.twoPair));
        assertEquals(9, ScoreColumn.getPatternIndex(PatternNames.threeOfAKind));
        assertEquals(10, ScoreColumn.getPatternIndex(PatternNames.fourOfAKind));
        assertEquals(11, ScoreColumn.getPatternIndex(PatternNames.fullHouse));
        assertEquals(12, ScoreColumn.getPatternIndex(PatternNames.smallStraight));
        assertEquals(13, ScoreColumn.getPatternIndex(PatternNames.largeStraight));
        assertEquals(14, ScoreColumn.getPatternIndex(PatternNames.yahtzee));
        assertEquals(15, ScoreColumn.getPatternIndex(PatternNames.chance));
        
    }

    @Test
    void getPatternIndexThrowsException() {
        assertThrows(IllegalStateException.class, ()-> {
            ScoreColumn.getPatternIndex(PatternNames.ones);
        });
    }

    @Test
    void getPatternIndexReturnsMinusOneAppropriately() {
        ScoreColumn scoreColumn = new ScoreColumn(1, "PG");
        assertEquals(-1, ScoreColumn.getPatternIndex("NON EXISTING PATTERN"));

    }


    
}
