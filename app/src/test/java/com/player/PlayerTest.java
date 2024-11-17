
package com.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.die.Die;

public class PlayerTest {
    private final Player player = new Player("Richard");

    @AfterEach
    void setup() {
        Player.setAmountOfPlayers(0);
    }

    @Test
    void canConstructPlayer() {
        String name = player.getName();
        assertEquals("Richard", name, "Names does not match");
    }

    @Test
    void canCountPlayers() {
        assertEquals(1, Player.getAmountPlayers());
        new Player("NONE");
        assertEquals(2, Player.getAmountPlayers());
    }

    @Test
    void canLimitAmountOfPlayers() {
        int maxPlayers = Player.getMaxPlayers();
        for (int i = 0; i < maxPlayers - 1; i++) {
            new Player("NONE");
        }
        assertThrows(IllegalStateException.class, () -> {
            new Player("None");
        });
    }

    @Test
    void canRollDice() {
        int iterations = 10_000;
        int[] diceValues = new int[5];
        for (int i = 0; i < iterations; i++) {
            diceValues = player.rollDice();
        }
        for (int e : diceValues) {
            assertTrue(e >= 1 && e <= 6);
        }
    }

    @Test
    void canThrowForRollChosenDice() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player.rollChosenDice(true, true);
        });
    }

    @Test
    void canRollSelectedDice() {
        Die[] dice = Player.getDice();
        boolean[] chosenDiceToRoll = {true, true, false, false, false};
        int[] diceValues = new int[5];

        Player.rollChosenDice(chosenDiceToRoll);
        for (int i = 0; i < dice.length; i++) {
            if (chosenDiceToRoll[i]) {
                diceValues[i] = dice[i].getFaceValue();
            }
        }

        for (int i = 0; i < dice.length; i++) {
            if (chosenDiceToRoll[i]) {
                assertEquals(diceValues[i], dice[i].getFaceValue());
            } else {
                assertNotEquals(diceValues[i], dice[i].getFaceValue());
            }
        }



    }

}
