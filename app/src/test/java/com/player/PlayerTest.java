
package com.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private final Player player = new Player("Richard");

    @AfterEach
    void setup() {
        Player.resetAmountPlayers();
    }

    @Test
    void canConstructPlayer() {
        String name = player.getName();
        assertEquals("Richard", name);
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
    void canRoleDice() {

    }
    
}
