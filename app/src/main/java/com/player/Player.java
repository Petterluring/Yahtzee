package com.player;

import com.die.Die;

/**
 * The player class is responsible for representing a player,
 * and capture the behaviour of a player such as rolling dice.
 */
public class Player {
    private String name;
    /**
     * The set of dice that is used in the game. Remark that the set is shared among all players.
     * All dice have six sides.
     */
    private static Die[] dice = { new Die(6), new Die(6), new Die(6), new Die(6), new Die(6) };
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
     * 
     * @return - The values of the roled dice.
     */
    public static int[] rollDice() {
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            diceValues[i] = dice[i].role();
        }
        return diceValues;
    }

    /**
     * Choose a set of dice to roll by inserting five booleans such as 
     * [true, true, false, false, false]. In this case, the first two dice will be
     * roled, and the rest will stay the same.
     * @param dieIDs - The chosen boolean array
     * @return - Returns the resulting dice values
     * @throws IllegalArgumentException - Array must be of lenght 5.
     */
    public static int[] rollChosenDice(boolean... dieIDs) throws IllegalArgumentException {
        if (dieIDs.length != 5) {
            throw new IllegalArgumentException("The array must be of lenght 5 since there are 5 dice");
        }
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            if (dieIDs[i]) {
                diceValues[i] = dice[i].role();
            }
        }
        return diceValues;

    }

    /**
     * Getter for name
     * @return - ...
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for dice
     * @return - ...
     */
    public static Die[] getDice() {
        return dice;
    }

    /**
     * Getter for the max amount of players value
     * @return - ...
     */
    public static int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Setter for the max amount of players value
     */
    public static void setMaxPlayers(int amount) {

    }

    /**
     * Getter for the current amount of players
     * @return - ...
     */
    public static int getAmountPlayers() {
        return amountPlayers;
    }

    /**
     * Set your amount of players that is in the game. This one should only be used if you 
     * remove a player from the game. The amount of players are increased automatically.
     * @param amount - ...
     * @throws IllegalArgumentException - Must stay in the range 0 <= amount <= maxPlayers
     */
    public static void setAmountOfPlayers(int amount) throws IllegalArgumentException {
        if (amount <= 0 && amount >= maxPlayers) {
            throw new IllegalArgumentException("The amount of players must at least be zero, and at most " + maxPlayers);
        }
        amountPlayers = amount;
    }
}
