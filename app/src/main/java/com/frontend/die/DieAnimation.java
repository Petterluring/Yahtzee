package com.frontend.die;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * This class animates an instance of DieDisplay. The animation could
 * be a die roll.
 */
public class DieAnimation {
    private static final Random RANDOM = new Random();
    private static final int UPPERINTBOUND = 6;


    /**
     * Choose a die to animate a roll
     * @param finalValue - The final value of the die
     * @param timeDiffMilli - The time taken until a new face appears
     * @param appearances - How many random sides will appear before reaching the final value?
     * @param die - Chosen instance of DieDisplay
     */
    public static void dieRoll(int finalValue, Double timeDiffMilli, int appearances,  DieDisplay die) {
        Timeline timeline = new Timeline();
        for (int i = 1; i <= appearances; i++) {
            int randomFaceValue = RANDOM.nextInt(UPPERINTBOUND) + 1;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(timeDiffMilli * (i - 1)), _-> die.setDie(randomFaceValue));
            timeline.getKeyFrames().add(keyFrame);
        }
        KeyFrame keyFrame = new KeyFrame(Duration.millis(timeDiffMilli * appearances), _-> die.setDie(finalValue));
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
