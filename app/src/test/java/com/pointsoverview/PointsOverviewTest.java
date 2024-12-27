package com.pointsoverview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.points.Points;
import com.points.PointsOverview;

class PointsOverviewTest {
    

    @Test
    void canAssignCorrectOverviewForCertains() {
        Points points = new Points(new int[]{1, 2, 3, 4, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(1, pointsOverview.getPattern(PatternNames.ONES));
        assertEquals(2, pointsOverview.getPattern(PatternNames.TWOS));
        assertEquals(3, pointsOverview.getPattern(PatternNames.THREES));
        assertEquals(4, pointsOverview.getPattern(PatternNames.FOURS));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FIVES));
        assertEquals(6, pointsOverview.getPattern(PatternNames.SIXES));
        assertEquals(16, pointsOverview.getPattern(PatternNames.CHANCE));

    }

    @Test
    void canAssignCorrectOverviewForLenghtOne() {
        Points points = new Points(new int[]{2, 2, 2, 2, 2});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(4, pointsOverview.getPattern(PatternNames.PAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.TWOPAIR));
        assertEquals(6, pointsOverview.getPattern(PatternNames.THREEOFAKIND));
        assertEquals(8, pointsOverview.getPattern(PatternNames.FOUROFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FULLHOUSE));
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        assertEquals(50, pointsOverview.getPattern(PatternNames.YAHTZEE));
    }

    @Test
    void canAssignCorrectOverviewForLenghtTwo() {
        Points points = new Points(new int[]{2, 2, 3, 3, 3});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(6, pointsOverview.getPattern(PatternNames.PAIR));
        assertEquals(10, pointsOverview.getPattern(PatternNames.TWOPAIR));
        assertEquals(9, pointsOverview.getPattern(PatternNames.THREEOFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FOUROFAKIND));
        assertEquals(13, pointsOverview.getPattern(PatternNames.FULLHOUSE));
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.YAHTZEE));
    }

    @Test
    void canAssignCorrectOverviewForLenghtThree() {
        Points points = new Points(new int[]{2, 2, 3, 3, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(6, pointsOverview.getPattern(PatternNames.PAIR));
        assertEquals(10, pointsOverview.getPattern(PatternNames.TWOPAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.THREEOFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FOUROFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FULLHOUSE));
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.YAHTZEE));
    }

    @Test
    void canAssignCorrectOverviewForLenghtFour() {
        Points points = new Points(new int[]{1, 1, 2, 3, 4});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(2, pointsOverview.getPattern(PatternNames.PAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.TWOPAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.THREEOFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FOUROFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FULLHOUSE));
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.YAHTZEE));
    }

    @Test
    void canAssignCorrectOverviewForLenghtFive() {
        Points points = new Points(new int[]{1, 2, 3, 4, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(0, pointsOverview.getPattern(PatternNames.PAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.TWOPAIR));
        assertEquals(0, pointsOverview.getPattern(PatternNames.THREEOFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FOUROFAKIND));
        assertEquals(0, pointsOverview.getPattern(PatternNames.FULLHOUSE));
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.YAHTZEE));

        points = new Points(new int[]{1, 2, 3, 4, 5});
        pointsOverview = new PointsOverview(points);
        assertEquals(15, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(0, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
        points = new Points(new int[]{2, 3, 4, 5, 6});
        pointsOverview = new PointsOverview(points);
        assertEquals(0, pointsOverview.getPattern(PatternNames.SMALLSTRAIGHT));
        assertEquals(20, pointsOverview.getPattern(PatternNames.LARGESTRAIGHT));
    }
}
