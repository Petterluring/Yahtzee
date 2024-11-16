package com.player;

import com.die.Die;

/**
 * The player class is responsible for representing a player, 
 * and capture the behaviour of a player such as rolling dice.
 */
public class Player {
    private String name;
    private static Die[] dice;
    private static int maxPlayers = 5;
    private static int amountPlayers = 0;

    public Player(String name) {
        this.name = name;
        
    }

    public void roleDice() {

    }

    public void roleChosenDice(int... dieIDs) {

    }

    public static Die[] getDice() {
        return dice;
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static void setMaxPlayers(int amount) {

    }

    public static int getAmountPlayers() {
        return amountPlayers;
    }

    private static void initDice() {
        
    }


}
