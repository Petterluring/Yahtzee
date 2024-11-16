package com.player;

import com.die.Die;

/**
 * The player class is responsible for representing a player,
 * and capture the behaviour of a player such as rolling dice.
 */
public class Player {
    private String name;
    private static Die[] dice = { new Die(), new Die(), new Die(), new Die(), new Die() };
    private static int maxPlayers = 5;
    private static int amountPlayers = 0;

    /**
     * Initializes a player
     * 
     * @param name - ...
     * @throws IllegalStateException - We may not have more than n players.
     */
    public Player(String name) throws IllegalStateException {
        if (amountPlayers == maxPlayers) {
            throw new IllegalStateException("The maximum amount of players may be " + maxPlayers);
        }
        this.name = name;
        amountPlayers++;
    }


    /**
     * Role all dice.
     * @return - The values of the roled dice.
     */
    public int[] roleDice() {
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            diceValues[i] = dice[i].role();
        }
        return diceValues;
    }

    public void roleChosenDice(boolean... dieIDs) {

    }

    public String getName() {
        return name;
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

    public static void resetAmountPlayers() {
        amountPlayers = 0;
    }
}
