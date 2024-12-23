package com.pointsoverview;

import java.util.HashMap;

import com.patternnames.PatternNames;
import com.points.Points;

/**
 * This class creates an overview of all the different patterns with
 * corresponding points for a set of 5 dice.
 */
public class PointsOverview {
    /**
     * The Points class is used here to identify patterns and return
     * points for the corresponding patterns.
     */
    private Points points;
    /**
     * We need the lenght of the HashMap contained in the Points instance
     * since the lenght can give us information about what patterns we can
     * exclude.
     */
    private int faceCounterLenght;
    /**
     * This hashmap will contain an overview of the differents patterns and points.
     * If you type say "Big Straight", then the map will give you the point for that
     * pattern.
     */
    private HashMap<String, Integer> overview;

    /**
     * The constructor constructs our overview hashmap which will contain
     * the points for all the patterns contained in a certain set of dice.
     * 
     * @param points - Points class for evaluating patterns with corresponding
     *               points.
     */
    public PointsOverview(Points points) {
        this.points = points;
        overview = new HashMap<>();
        faceCounterLenght = points.getFaceCounter().size();
        certain();
        if (faceCounterLenght == 1) {
            lenghtOne();
        } else if (faceCounterLenght == 2) {
            lenghtTwo();
        } else if (faceCounterLenght == 3) {
            lenghtThree();
        } else if (faceCounterLenght == 4) {
            lenghtFour();
        } else {
            lenghtFive();
        }

    }

    /**
     * In the following private methods, we create different overviews
     * depending on the lenght of the hashmap contained in Points instance.
     * A certain lenght will give us a hint of what patterns we may exclude.
     * This means that we may assign 0 points to some patterns right away.
     * E.g. if the lenght of the hashmap in question is one, we know for
     * certain that straight may be excluded since one of the conditions is
     * that all face values are distinct, meaning that the face counter hashmap
     * must be of lenght 5.
     * 
     * BEGIN
     */

    /**
     * This method is called no matter what the lenght since there is no lenght
     * that will exclude these.
     */
    private void certain() {
        overview.put(PatternNames.ones, points.onesToSixes(1));
        overview.put(PatternNames.twos, points.onesToSixes(2));
        overview.put(PatternNames.threes, points.onesToSixes(3));
        overview.put(PatternNames.fours, points.onesToSixes(4));
        overview.put(PatternNames.fives, points.onesToSixes(5));
        overview.put(PatternNames.sixes, points.onesToSixes(6));
        overview.put(PatternNames.chance, points.chance());
    }

    private void lenghtOne() {
        overview.put(PatternNames.pair, points.pair());
        overview.put(PatternNames.twoPair, 0);
        overview.put(PatternNames.threeOfAKind, points.threeOfAKind());
        overview.put(PatternNames.fourOfAKind, points.fourOfAKind());
        overview.put(PatternNames.fullHouse, 0);
        overview.put(PatternNames.smallStraight, 0);
        overview.put(PatternNames.largeStraight, 0);
        overview.put(PatternNames.yahtzee, points.Yahtzee());

    }

    private void lenghtTwo() {
        overview.put(PatternNames.pair, points.pair());
        overview.put(PatternNames.twoPair, points.twoPair());
        overview.put(PatternNames.threeOfAKind, points.threeOfAKind());
        overview.put(PatternNames.fourOfAKind, points.fourOfAKind());
        overview.put(PatternNames.fullHouse, points.fullHouse());
        overview.put(PatternNames.smallStraight, 0);
        overview.put(PatternNames.largeStraight, 0);
        overview.put(PatternNames.yahtzee, 0);

    }

    private void lenghtThree() {
        overview.put(PatternNames.pair, points.pair());
        overview.put(PatternNames.twoPair, points.twoPair());
        overview.put(PatternNames.threeOfAKind, points.threeOfAKind());
        overview.put(PatternNames.fourOfAKind, 0);
        overview.put(PatternNames.fullHouse, 0);
        overview.put(PatternNames.smallStraight, 0);
        overview.put(PatternNames.largeStraight, 0);
        overview.put(PatternNames.yahtzee, 0);

    }

    private void lenghtFour() {
        overview.put(PatternNames.pair, points.pair());
        overview.put(PatternNames.twoPair, 0);
        overview.put(PatternNames.threeOfAKind, 0);
        overview.put(PatternNames.fourOfAKind, 0);
        overview.put(PatternNames.fullHouse, 0);
        overview.put(PatternNames.smallStraight, 0);
        overview.put(PatternNames.largeStraight, 0);
        overview.put(PatternNames.yahtzee, 0);

    }

    private void lenghtFive() {
        overview.put(PatternNames.pair, 0);
        overview.put(PatternNames.twoPair, 0);
        overview.put(PatternNames.threeOfAKind, 0);
        overview.put(PatternNames.fourOfAKind, 0);
        overview.put(PatternNames.fullHouse, 0);
        overview.put(PatternNames.smallStraight, points.straight(false));
        overview.put(PatternNames.largeStraight, points.straight(true));
        overview.put(PatternNames.yahtzee, 0);

    }

    /**
     * END
     */

    /**
     * Returns the point for a given pattern in the overview hashmap.
     * 
     * @param pattern - Chosen pattern
     * @return - Returns the point mapped to a pattern
     * @throws IllegalArgumentException - The chosen pattern must exist in the
     *                                  overview
     */
    public int getPattern(String pattern) throws IllegalArgumentException {
        if (!overview.containsKey(pattern)) {
            throw new IllegalArgumentException("Pattern does not exist in the overview");
        }
        return overview.get(pattern);
    }

}
