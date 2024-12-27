package com.points;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PointsTest {

    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Points(new int[] { 1, 2, 3, 4 });
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Points(new int[] { 1, 2, 3, 4, -1 });
        });
    }

    @Test
    void canCountFaceValues() {
        Points points = new Points(new int[] { 1, 1, 1, 1, 1 });
        HashMap<Integer, Integer> hashMap = points.getFaceCounter();
        assertEquals(1, hashMap.size());
        assertEquals(5, hashMap.get(1));

        points = new Points(new int[] { 1, 1, 1, 1, 2 });
        hashMap = points.getFaceCounter();
        assertEquals(2, hashMap.size());
        assertEquals(4, hashMap.get(1));
        assertEquals(1, hashMap.get(2));
    }

    @Test
    void canCalculateForOnesToSixes() {
        Points points = new Points(new int[] { 1, 1, 1, 1, 1 });
        assertEquals(5, points.onesToSixes(1));
        points = new Points(new int[] { 6, 2, 2, 2, 2 });
        assertEquals(2 * 4, points.onesToSixes(2));
        assertEquals(6, points.onesToSixes(6));
        assertEquals(0, points.onesToSixes(3));
    }

    @Test
    void canCalculateHighestPair() {
        Points points = new Points(new int[] { 1, 1, 2, 2, 3 });
        assertEquals(4, points.pair());
        points = new Points(new int[] { 1, 1, 2, 6, 6 });
        assertEquals(12, points.pair());
        points = new Points(new int[] { 1, 1, 1, 5, 5 });
        assertEquals(10, points.pair());
        points = new Points(new int[] { 6, 6, 6, 5, 5 });
        assertEquals(12, points.pair());
        points = new Points(new int[] { 6, 6, 6, 6, 6 });
        assertEquals(12, points.pair());
        points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(0, points.pair());
    }

    @Test
    void canCalculateTwoPair() {
        Points points = new Points(new int[] { 1, 1, 2, 2, 3 });
        assertEquals(6, points.twoPair());
        points = new Points(new int[] { 1, 1, 2, 6, 6 });
        assertEquals(14, points.twoPair());
        points = new Points(new int[] { 1, 1, 1, 6, 6 });
        assertEquals(14, points.twoPair());
        points = new Points(new int[] { 1, 1, 1, 1, 1 });
        assertEquals(0, points.twoPair());
        points = new Points(new int[] { 1, 2, 3, 6, 6 });
        assertEquals(0, points.twoPair());
        points = new Points(new int[] { 1, 2, 3, 5, 6 });
        assertEquals(0, points.twoPair());
    }

    @Test
    void canCalculateThreeOfKind() {
        Points points = new Points(new int[] { 1, 1, 2, 2, 2 });
        assertEquals(6, points.threeOfAKind());
        points = new Points(new int[] { 1, 2, 2, 2, 2 });
        assertEquals(6, points.threeOfAKind());
        points = new Points(new int[] { 2, 2, 2, 2, 2 });
        assertEquals(6, points.threeOfAKind());
        points = new Points(new int[] { 2, 2, 3, 3, 3 });
        assertEquals(9, points.threeOfAKind());
        points = new Points(new int[] { 1, 2, 3, 4, 4 });
        assertEquals(0, points.threeOfAKind());
        points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(0, points.threeOfAKind());
    }

    @Test
    void canCalculateFourOfKind() {
        Points points = new Points(new int[] { 1, 2, 2, 2, 2 });
        assertEquals(8, points.fourOfAKind());
        points = new Points(new int[] { 2, 2, 2, 2, 2 });
        assertEquals(8, points.fourOfAKind());
        points = new Points(new int[] { 2, 2, 2, 2, 2 });
        assertEquals(8, points.fourOfAKind());
        points = new Points(new int[] { 2, 2, 3, 3, 3 });
        assertEquals(0, points.fourOfAKind());
        points = new Points(new int[] { 1, 2, 3, 4, 4 });
        assertEquals(0, points.fourOfAKind());
        points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(0, points.fourOfAKind());
    }

    @Test
    void canCalculateStraight() {
        Points points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(15, points.straight(false));
        assertEquals(0, points.straight(true));
        points = new Points(new int[] { 2, 3, 4, 5, 6 });
        assertEquals(0, points.straight(false));
        assertEquals(20, points.straight(true));
        points = new Points(new int[] { 2, 2, 2, 5, 6 });
        assertEquals(0, points.straight(false));
        assertEquals(0, points.straight(true));

    }

    @Test
    void canReturnPointFullHouse() {
        Points points = new Points(new int[] { 2, 2, 3, 3, 3 });
        assertEquals(2 * 2 + 3 * 3, points.fullHouse());
        points = new Points(new int[] { 3, 3, 4, 4, 4 });
        assertEquals(3 * 2 + 4 * 3, points.fullHouse());
        points = new Points(new int[] { 3, 3, 4, 4, 5 });
        assertEquals(0, points.fullHouse());
        points = new Points(new int[] { 4, 4, 4, 4, 2 });
        assertEquals(0, points.fullHouse());
        points = new Points(new int[] { 4, 4, 4, 4, 4 });
        assertEquals(0, points.fullHouse());
    }

    @Test
    void canReturnPointForYahtzee() {
        for (int faceValue = 1; faceValue <= 6; faceValue++) {
            Points points = new Points(new int[] { faceValue, faceValue, faceValue, faceValue, faceValue });
            assertEquals( 50, points.Yahtzee());
        }
        Points points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals( 0, points.Yahtzee());
        points = new Points(new int[] { 1, 1, 3, 4, 5 });
        assertEquals( 0, points.Yahtzee());
        points = new Points(new int[] { 1, 1, 1, 4, 5 });
        assertEquals( 0, points.Yahtzee());
        points = new Points(new int[] { 1, 1, 1, 1, 5 });
        assertEquals( 0, points.Yahtzee());
        
    }

    @Test
    void canCalculateChance() {
        Points points = new Points(new int[] { 1, 2, 3, 4, 5 });
        assertEquals( 15, points.chance());
        points = new Points(new int[] { 1, 1, 3, 4, 5 });
        assertEquals( 14, points.chance());
        points = new Points(new int[] { 1, 1, 1, 4, 5 });
        assertEquals( 12, points.chance());
        points = new Points(new int[] { 1, 1, 1, 1, 5 });
        assertEquals( 9, points.chance());
        points = new Points(new int[] { 1, 1, 1, 1, 1 });
        assertEquals( 5, points.chance());
    }
}
