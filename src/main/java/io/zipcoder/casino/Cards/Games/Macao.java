package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.utilities.Console;

public class Macao extends Game {

    private MacaoPlayer macaoGuest;
    private MacaoPlayer macaoComputer;
    private boolean isOver;
    private Dice dice;
    private Console console;
    private boolean guestStillPlaying;
    private boolean computerStillPlaying;


    public Macao() {
        this.macaoGuest = new MacaoPlayer();
        this.macaoComputer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = new Console();
        this.guestStillPlaying = true;
        this.computerStillPlaying = true;
    }

    public void play() {
        initialGameSetup();
        while(!isOver) {
            if (isGuestStillPlaying()) {
                rollDie(macaoGuest);
                showGuestRoll();
            }
            if(didGuestGoOver()) {
                youWentOver();
                break;
            }
            if(isComputerStillPlaying()) {
                rollDie(macaoComputer);
                showComputerRoll();
            }
            evaluate();
        }
    }

    public void rollDie(MacaoPlayer player) {
        player.roll = dice.roll();
        player.cumulativeRoll += player.roll;
    }

    public void showInitialRolls() {
        console.print("You rolled a %s and the computer rolled a %s. ", macaoGuest.roll, macaoComputer.roll);
    }

    public void showGuestRoll() {
        console.println("You rolled a %s and your total is now %s.", macaoGuest.roll, macaoGuest.cumulativeRoll);
    }

    public void showComputerRoll() {
        console.println("The computer rolled a %s and its total is now %s.", macaoComputer.roll, macaoComputer.cumulativeRoll);
    }

    public void initialGameSetup(){
        rollDie(macaoGuest);
        rollDie(macaoComputer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.cumulativeRoll == 9) {
            guestStillPlaying = false;
        }
        if (macaoGuest.cumulativeRoll < 9 && guestStillPlaying) {
            String yesOrNo = console.getStringInput("Would you like to roll again?");
            if (!yesOrNo.equals("yes")) {
                guestStillPlaying = false;
            }
        }
        return guestStillPlaying;
    }

    public void youWentOver() {
        console.println("Sorry, you went over. You lose!");
    }

    public boolean didGuestGoOver() {
        boolean guestWentOver = false;
        if (macaoGuest.cumulativeRoll > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isComputerStillPlaying() {
        if (computerStillPlaying) {
            if (macaoComputer.cumulativeRoll > 6 && macaoComputer.cumulativeRoll > macaoGuest.cumulativeRoll) {
                computerStillPlaying = false;
            }
            if (macaoComputer.cumulativeRoll > 7) {
                computerStillPlaying = false;
            }
        }
        return computerStillPlaying;
    }

    public void evaluate() {
        if (macaoComputer.cumulativeRoll > 9) {
            console.println("The computer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && computerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.cumulativeRoll > macaoComputer.cumulativeRoll) {
                console.println("Your total is %s and the computer's total is %s. You win!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoComputer.cumulativeRoll >  macaoGuest.cumulativeRoll) {
                console.println("Your total is %s and the computer's total is %s. Sorry, you lose!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoGuest.cumulativeRoll == macaoComputer.cumulativeRoll) {
                console.println("It's a tie!");
            }
        }
    }

    public static void main(String[] args) {
        Macao macao = new Macao();
        macao.play();
    }
}
