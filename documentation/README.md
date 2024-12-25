# Yahtzee
Yahtzee is a game where you throw 5 6-sided dice and collect points, were the points are dependent on dice patterns. E.g. one such pattern is called Yahtzee, as the name of the game, which is identified as 5 dice with the same face value.

## Goal of the game and rules
The game is played in 13 rounds. For each round, a player role the dice three times; all 5 dice must be thrown on the first round, then any subset of the 5 dice may be thrown again on the second and third role. The goal of the game is to collect the most points out of all players. The points are collected by attaining different die patterns which will give you certain points. Once a pattern have been used, then that pattern may not be used again. If a player can't attain a pattern that have not been used for some round, then the player must sacrifice some unused pattern by adding zero points for that pattern. The points and the used patterns are tracked in a Yahtzee scoretable which we will describe later.

## Patterns and points
When we say *dice set*, we mean the 5 dice that is used in the game.

The possible patterns with points are the following: 
* Ones   
Any die set containing ones. The point for the pattern is calculated by taking the sum of the ones. The same logic applies for twos to sixes.
* Twos
* Threes
* Fours
* Fives
* Sixes

* Pair   
Any die set that contain two of the same face values. The point is derived by taking the sum of those face values.
* Two-pair   
Any die set that contain two pairs. The point is derived by taking the sum of the points from the individual pairs.
* Three of a kind   
Any die set that contain three of the same face values. The point is derived by taking the sum of those three face values.
* Four of a kind   
Any set that contain four of the same face values. The point is derived by taking the sum of those four face values.
* Full house   
Any set that contain a three of a kind and a pair. The point is derived by taking the sum of the points from the three of a kind and the pair.
* Small straight   
The die set containing 5 distinct face values which ranges from 1-5. The point is derived by taking the sum of the dice.
* Large straight   
The die set containing 5 distinct face values which ranges from 2-6. The point is derived by taking the sum of the dice.
* YAHTZEE   
Any die set containing 5 dice with the same face value. The point for this set is 50.
* Chance   
Any die set. The point is derived by taking the sum of the face values.

Remark that a die set may have multiple patterns. E.g. the die set ${6, 6, 6, 6, 6}$ can be identified as a YAHTZEE, sixes, pair, two-pair, chance and more.

## Example round


## Scoreboard

To keep track of the players attained patterns with points, we construct a Yahtzee table in the following way: 

| **Category**          | **Player 1**    | **Player 2**    |... **Player n**    |
|-----------------------|-----------------|-----------------|-----------------|
| **Upper Section**     |                 |                 |                 |
| Ones                  |                 |                 |                 |
| Twos                  |                 |                 |                 |
| Threes                |                 |                 |                 |
| Fours                 |                 |                 |                 |
| Fives                 |                 |                 |                 |
| Sixes                 |                 |                 |                 |
| **Bonus**             | +50             | +50             | +50             |
| **Upper Total**       |                 |                 |                 |
| **Lower Section**     |                 |                 |                 |
| Three of a Kind       |                 |                 |                 |
| Four of a Kind        |                 |                 |                 |
| Full House            |                 |                 |                 |
| Small Straight        |                 |                 |                 |
| Large Straight        |                 |                 |                 |
| Yahtzee               |                 |                 |                 |
| Chance                |                 |                 |                 |
| **Grand Total**       |                 |                 |                 |

