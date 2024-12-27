
package com.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.die.Die;

class PlayerTest {
    private final Player player = new Player("Richard", "Samson");
    private final String nameError = "Names does not match";
    @Test
    void canConstructPlayer() {
        String firstName = player.getFirstName();
        assertEquals("Richard", firstName, nameError);
        String lastName = player.getLastName();
        assertEquals("Samson", lastName, nameError);
        String name = player.getName();
        assertEquals("Richard Samson", name, nameError);
    }

    @Test
    void canRollDice() {
        int iterations = 10_000;
        int[] diceValues = new int[5];
        for (int i = 0; i < iterations; i++) {
            diceValues = Player.rollDice();
            for (int e : diceValues) {
                assertTrue(e >= 1 && e <= 6);
            }
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
        boolean[] chosenDiceToRoll = { true, true, false, false, false };
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
