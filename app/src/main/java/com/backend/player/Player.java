package com.backend.player;

import com.backend.die.Die;

/**
 * The player class is responsible for representing a player,
 * and capture the behaviour of a player such as rolling dice.
 */
public class Player {
    private String firstName;
    private String lastName;
    /**
     * Amount of players
     */
    private static int amount = 0;
    private int id;

    /**
     * The set of dice that is used in the game. Remark that the set is shared among
     * all players.
     * All dice have six sides.
     */
    private static Die[] dice = { 
        new Die(6), new Die(6),
        new Die(6), new Die(6),
        new Die(6) };

    
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = amount;
        amount++;
    }

    /**
     * Roll all dice.
     * @return - The values of the roled dice.
     */
    public static int[] rollDice() {
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            diceValues[i] = dice[i].roll();
        }
        return diceValues;
    }

    /**
     * Choose a set of dice to roll by inserting five booleans such as
     * [true, true, false, false, false]. In this case, the first two dice will be
     * roled, and the rest will stay the same.
     * 
     * @param chosenDiceToRoll - The chosen boolean array
     * @return - Returns the resulting dice values
     * @throws IllegalArgumentException - Array must be of lenght 5.
     */
    public static int[] rollChosenDice(boolean... chosenDiceToRoll) throws IllegalArgumentException {
        if (chosenDiceToRoll.length != 5) {
            throw new IllegalArgumentException("The array must be of lenght 5 since there are 5 dice");
        }
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            if (chosenDiceToRoll[i]) {
                diceValues[i] = dice[i].roll();
            }
        }
        return diceValues;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public static Die[] getDice() {
        return dice;
    }

    public int getID() {
        return id;
    }
}
