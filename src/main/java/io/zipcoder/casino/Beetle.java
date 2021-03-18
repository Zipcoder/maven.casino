package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Beetle extends DiceGame{
    //Console console = new Console();
    Scanner scanner = new Scanner(System.in);

    Boolean GameState = true;
    BeetleDisplay bd = new BeetleDisplay();
    private String[][] completeBeetle = new String[][]{{"\\","0","/"},
        {"⎛","|","⎞"},
        {"⎝","|","⎠"},
        {"/","⏝","\\"}
    };
    private String[][] usersBeetle = new String[][]{{" "," "," "},
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
    };
    private String[][] opponentsBeetle = new String[][]{{" "," "," "},
        {" "," "," "},
        {" "," "," "},
        {" "," "," "}
    };

    private Set<Integer> usersRolls = new HashSet<Integer>();
    private Set<Integer> opponentsRolls = new HashSet<Integer>();
    
    
    public Beetle() {
    }
    
    //if opponent set is equal to or greater than user set opponent will bet.
    
    //facilitator
    public void gameEngine() {
        Boolean userWins = false;
        Boolean opponentWins = false;
        Boolean playersTied = false;

        while (!playersTied && !userWins && !opponentWins) {
            System.out.println("Would you like to place a bet?");
            String userInput = scanner.nextLine();
            Integer userRollValue = diceRollSum(1);
            bd.usersRollResults(userRollValue);
            analyzeRoll(usersRolls, usersBeetle, userRollValue);
            drawPlayerBeetle(usersBeetle);

            Integer opponentsRollValue = diceRollSum(1);
            bd.opponentsRollResults(opponentsRollValue);
            analyzeRoll(opponentsRolls, opponentsBeetle, opponentsRollValue);
            drawPlayerBeetle(opponentsBeetle);

            if (getCompleteBeetle() == getUsersBeetle() && getCompleteBeetle() == getOpponentsBeetle()) {
                playersTied = true;
                break;
                }
            else if (getCompleteBeetle() == getUsersBeetle()) {
                userWins = true;
                break;
                }
            else if (getCompleteBeetle() == getOpponentsBeetle()) {
                opponentWins = true;
                break;
                }
            }
        }


    public void analyzeRoll(Set<Integer> rollSet, String[][] playersBeetle, Integer diceRoll){
        if(!rollSet.contains(diceRoll)) {
            drawBeetle(rollSet, playersBeetle,diceRoll);
            rollSet.add(diceRoll);
        }
        else {
                bd.repeatedRollResult();
            }
    }

    public void drawBeetle(Set rollSet, String[][] playersBeetle, Integer diceRoll) {

        switch (diceRoll) {
            case 1:
                bd.drewLeg();
                playersBeetle[0][0] = completeBeetle[0][0];
                break;
            case 2:
                bd.drewLeg();
                playersBeetle[0][2] = completeBeetle[0][2];
                break;
            case 3:
                bd.drewLeg();
                playersBeetle[3][0] = completeBeetle[3][0];
                break;
            case 4:
                bd.drewLeg();
                playersBeetle[3][2] = completeBeetle[3][2];
                break;
            case 5:
                bd.drewHead();
                playersBeetle[0][1] = completeBeetle[0][1];
                playersBeetle[1][1] = completeBeetle[1][1];
                playersBeetle[2][1] = completeBeetle[2][1];
                break;
            case 6:
                bd.drewBody();
                playersBeetle[1][0] = completeBeetle[1][0];
                playersBeetle[1][2] = completeBeetle[1][2];
                playersBeetle[2][0] = completeBeetle[2][0];
                playersBeetle[2][2] = completeBeetle[2][2];
                playersBeetle[3][1] = completeBeetle[3][1];

                break;
            default:
                System.out.println("something went wrong");
                break;
        }
    }

    public String[][] drawPlayerBeetle(String[][] playersBeetle){
        for (int i = 0; i < playersBeetle.length; i++) {
            for (int j = 0; j < playersBeetle[i].length; j++) {
                System.out.print(playersBeetle[i][j] + " ");
            }
            System.out.println();
        }
        return playersBeetle;
    }

    public Set<Integer> getUsersRolls() {
        return usersRolls;
    }

    public Set<Integer> getOpponentsRolls() {
        return opponentsRolls;
    }

    public String[][] getUsersBeetle(){
        return usersBeetle;
    }

    public String[][] getOpponentsBeetle(){
        return opponentsBeetle;
    }

    public String[][] getCompleteBeetle(){
        return completeBeetle;
    }




    public String startGame() {
        return null;
    }

    public String acceptBetFrom() {
        return null;
    }

    public String calculateReward() {
        return null;
    }

    public String calculateLoss() {
        return null;
    }

    public String endGame() {
        return null;
    }
}