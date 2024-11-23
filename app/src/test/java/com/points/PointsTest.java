package com.points;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class PointsTest {


    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Points(new int[]{1, 2, 3, 4});
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Points(new int[]{1, 2, 3, 4, -1});
        });
    }

    @Test
    void canCountFaceValues() {
        Points points = new Points(new int[]{1, 1, 1, 1, 1});
        HashMap<Integer, Integer> hashMap = points.getFaceCounter();
        assertEquals(1, hashMap.size());
        assertEquals(5, hashMap.get(1));

        points = new Points(new int[]{1, 1, 1, 1, 2});
        hashMap = points.getFaceCounter();
        assertEquals(2, hashMap.size());
        assertEquals(4, hashMap.get(1));
        assertEquals(1, hashMap.get(2));
    }

    @Test
    void canCalculateForOnesToSixes() {
        Points points = new Points(new int[]{1, 1, 1, 1, 1});
        assertEquals(5, points.onesToSixes(1));
        points = new Points(new int[]{6, 2, 2, 2, 2});
        assertEquals(2*4, points.onesToSixes(2));
        assertEquals(6, points.onesToSixes(6));
        assertEquals(-1, points.onesToSixes(3));
    }

    @Test
    void canCalculateHighestPair() {
        Points points = new Points(new int[]{1, 1, 2, 2, 3});
        assertEquals(4, points.pair());
        points = new Points(new int[]{1, 1, 2, 6, 6});
        assertEquals(12, points.pair());
        points = new Points(new int[]{1, 1, 1, 5, 5});
        assertEquals(10, points.pair());
        points = new Points(new int[]{6, 6, 6, 5, 5});
        assertEquals(12, points.pair());
        points = new Points(new int[]{1, 2, 3, 4, 5});
        assertEquals(-1, points.pair());
    }

    
    @Test
    void canCalculateStraight() {
        Points points = new Points(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, points.straight(false));
        assertEquals(-1, points.straight(true));
        points = new Points(new int[]{2, 3, 4, 5, 6});
        assertEquals(-1, points.straight(false));
        assertEquals(20, points.straight(true));
        points = new Points(new int[]{2, 2, 2, 5, 6});
        assertEquals(-1, points.straight(false));
        assertEquals(-1, points.straight(true));

    }
}
