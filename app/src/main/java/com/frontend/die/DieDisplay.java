package com.frontend.die;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/*
 * This class creates 2-dimensional dice objects.
 */
public class DieDisplay {
    private StackPane die;
    private final Rectangle DIEBASE;
    private final Circle TOPLEFT;
    private final Circle TOPRIGHT;
    private final Circle MIDLEFT;
    private final Circle MIDCENTER;
    private final Circle MIDRIGHT;
    private final Circle BOTTOMLEFT;
    private final Circle BOTTOMRIGHT;
    private static final double AREAFRACTION = 0.04;
    private static final double CONSTANTSPACINGBETWEENDOTS = 4;
    private static final Random random = new Random();

    /**
     * Builds the die with a certain lenght of its sides and color. 
     * @param sideLen - Chosen side lenght
     * @param dieColor - Chosen color on die
     * @param dotColor - Chosen color on the dots representing face values
     */
    public DieDisplay(Double sideLen, String dieColor, String dotColor) {
        // Init side
        DIEBASE = new Rectangle(sideLen, sideLen, Paint.valueOf(dieColor));
        double recArea = sideLen * sideLen;

        // Init dots
        double radius = Math.sqrt((AREAFRACTION * recArea) / Math.PI);
        TOPLEFT = new Circle(radius, Paint.valueOf(dotColor));
        TOPRIGHT = new Circle(radius, Paint.valueOf(dotColor));
        MIDLEFT = new Circle(radius, Paint.valueOf(dotColor));
        MIDCENTER = new Circle(radius, Paint.valueOf(dotColor));
        MIDRIGHT = new Circle(radius, Paint.valueOf(dotColor));
        BOTTOMLEFT = new Circle(radius, Paint.valueOf(dotColor));
        BOTTOMRIGHT = new Circle(radius, Paint.valueOf(dotColor));

        // Build the die
        HBox rowOne = new HBox(TOPLEFT, TOPRIGHT);
        HBox rowTwo = new HBox(MIDLEFT, MIDCENTER, MIDRIGHT);
        HBox rowThree = new HBox(BOTTOMLEFT, BOTTOMRIGHT);
        VBox rows = new VBox(rowOne, rowTwo, rowThree);

        // Setting alignment
        rowOne.setAlignment(Pos.CENTER);
        rowTwo.setAlignment(Pos.CENTER);
        rowThree.setAlignment(Pos.CENTER);
        rows.setAlignment(Pos.CENTER);

        // Setting distance between objects
        rowOne.setSpacing((radius + CONSTANTSPACINGBETWEENDOTS) * 2);
        rowTwo.setSpacing(CONSTANTSPACINGBETWEENDOTS);
        rowThree.setSpacing((radius + CONSTANTSPACINGBETWEENDOTS) * 2);
        rows.setSpacing(CONSTANTSPACINGBETWEENDOTS);

        // Stacking objects
        die = new StackPane(DIEBASE, rows);
        setDie(random.nextInt(6) + 1);
    }

    /**
     * Choose a face value to display
     * @param faceValue - int value between 1 to 6
     * @throws IllegalArgumentException - Thrown when faceValue is outside the range 1 to 6
     */
    public void setDie(int faceValue) throws IllegalArgumentException {
        switch (faceValue) {
            case 1:
                displayOne();
                return;
            case 2:
                displayTwo();
                return;
            case 3:
                displayThree();
                return;
            case 4:
                displayFour();
                return;
            case 5:
                displayFive();
                return;
            case 6:
                displaySix();
                return;
            default:
                throw new IllegalArgumentException("faceValue must be in the range 1 to 6");
        }
    }


    private void displayOne() {
        TOPLEFT.setVisible(false);
        TOPRIGHT.setVisible(false);
        MIDLEFT.setVisible(false);
        MIDCENTER.setVisible(true);
        MIDRIGHT.setVisible(false);
        BOTTOMLEFT.setVisible(false);
        BOTTOMRIGHT.setVisible(false);

    }

    private void displayTwo() {
        TOPLEFT.setVisible(true);
        TOPRIGHT.setVisible(false);
        MIDLEFT.setVisible(false);
        MIDCENTER.setVisible(false);
        MIDRIGHT.setVisible(false);
        BOTTOMLEFT.setVisible(false);
        BOTTOMRIGHT.setVisible(true);
    }

    private void displayThree() {
        TOPLEFT.setVisible(true);
        TOPRIGHT.setVisible(false);
        MIDLEFT.setVisible(false);
        MIDCENTER.setVisible(true);
        MIDRIGHT.setVisible(false);
        BOTTOMLEFT.setVisible(false);
        BOTTOMRIGHT.setVisible(true);
    }

    private void displayFour() {
        TOPLEFT.setVisible(true);
        TOPRIGHT.setVisible(true);
        MIDLEFT.setVisible(false);
        MIDCENTER.setVisible(false);
        MIDRIGHT.setVisible(false);
        BOTTOMLEFT.setVisible(true);
        BOTTOMRIGHT.setVisible(true);
    }

    private void displayFive() {
        TOPLEFT.setVisible(true);
        TOPRIGHT.setVisible(true);
        MIDLEFT.setVisible(false);
        MIDCENTER.setVisible(true);
        MIDRIGHT.setVisible(false);
        BOTTOMLEFT.setVisible(true);
        BOTTOMRIGHT.setVisible(true);
    }

    private void displaySix() {
        TOPLEFT.setVisible(true);
        TOPRIGHT.setVisible(true);
        MIDLEFT.setVisible(true);
        MIDCENTER.setVisible(false);
        MIDRIGHT.setVisible(true);
        BOTTOMLEFT.setVisible(true);
        BOTTOMRIGHT.setVisible(true);
    }

    public void setDieColor(String color) {
        DIEBASE.setFill(Paint.valueOf(color));
    }

    public StackPane getDie() {
        return die;
    }
}
