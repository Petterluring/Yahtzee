package com.pointsoverview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.patternnames.PatternNames;
import com.points.Points;

public class PointsOverviewTest {
    

    @Test
    void canAssignCorrectOverviewForCertains() {
        Points points = new Points(new int[]{1, 2, 3, 4, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(1, pointsOverview.getPattern(PatternNames.ones));
        assertEquals(2, pointsOverview.getPattern(PatternNames.twos));
        assertEquals(3, pointsOverview.getPattern(PatternNames.threes));
        assertEquals(4, pointsOverview.getPattern(PatternNames.fours));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fives));
        assertEquals(6, pointsOverview.getPattern(PatternNames.sixes));
        assertEquals(16, pointsOverview.getPattern(PatternNames.chance));

    }

    @Test
    void canAssignCorrectOverviewForLenghtOne() {
        Points points = new Points(new int[]{2, 2, 2, 2, 2});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(4, pointsOverview.getPattern(PatternNames.pair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.twoPair));
        assertEquals(6, pointsOverview.getPattern(PatternNames.threeOfAKind));
        assertEquals(8, pointsOverview.getPattern(PatternNames.fourOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fullHouse));
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        assertEquals(50, pointsOverview.getPattern(PatternNames.yahtzee));
    }

    @Test
    void canAssignCorrectOverviewForLenghtTwo() {
        Points points = new Points(new int[]{2, 2, 3, 3, 3});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(6, pointsOverview.getPattern(PatternNames.pair));
        assertEquals(10, pointsOverview.getPattern(PatternNames.twoPair));
        assertEquals(9, pointsOverview.getPattern(PatternNames.threeOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fourOfAKind));
        assertEquals(13, pointsOverview.getPattern(PatternNames.fullHouse));
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.yahtzee));
    }

    @Test
    void canAssignCorrectOverviewForLenghtThree() {
        Points points = new Points(new int[]{2, 2, 3, 3, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(6, pointsOverview.getPattern(PatternNames.pair));
        assertEquals(10, pointsOverview.getPattern(PatternNames.twoPair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.threeOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fourOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fullHouse));
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.yahtzee));
    }

    @Test
    void canAssignCorrectOverviewForLenghtFour() {
        Points points = new Points(new int[]{1, 1, 2, 3, 4});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(2, pointsOverview.getPattern(PatternNames.pair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.twoPair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.threeOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fourOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fullHouse));
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.yahtzee));
    }

    @Test
    void canAssignCorrectOverviewForLenghtFive() {
        Points points = new Points(new int[]{1, 2, 3, 4, 6});
        PointsOverview pointsOverview = new PointsOverview(points);
        assertEquals(0, pointsOverview.getPattern(PatternNames.pair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.twoPair));
        assertEquals(0, pointsOverview.getPattern(PatternNames.threeOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fourOfAKind));
        assertEquals(0, pointsOverview.getPattern(PatternNames.fullHouse));
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.yahtzee));

        points = new Points(new int[]{1, 2, 3, 4, 5});
        pointsOverview = new PointsOverview(points);
        assertEquals(15, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(0, pointsOverview.getPattern(PatternNames.largeStraight));
        points = new Points(new int[]{2, 3, 4, 5, 6});
        pointsOverview = new PointsOverview(points);
        assertEquals(0, pointsOverview.getPattern(PatternNames.smallStraight));
        assertEquals(20, pointsOverview.getPattern(PatternNames.largeStraight));
    }
}
