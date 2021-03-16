package io.zipcoder.casino;

public class CrapsDisplay extends Display {

    public void rulesMenu1(){
        currentDisplaySP("Welcome to Craps!\nIn Craps, the 'shooter' rolls two dice repeatedly.\nTheir first roll, the 'come out roll,' has three potential outcomes.\nA 7 or 11 total is a pass. A 2, 3, or 12 is craps. Anything else is a point.\nYou can bet 'pass' (the shooter rolls a pass) or 'don't pass' (the shooter rolls craps) for 1 to 1 payout.\nThe shooter keeps rolling until a point is set. On a point outcome, the number rolled is saved.\nNow, the shooter can 'come' by hitting the point outcome again, or 'seven out,' ending the round by rolling a 7.\nYou can bet 'come' (shooter hits point before sevening out) or 'don't come' (vice versa) for 1 to 1 payout.\nType rules2 for more technical rules.");
    }

    public void rulesMenu2(){
        currentDisplaySP("There are a number of extra bets you can make, called propositions.\nOne-roll propositions are a bet that the next roll will land on a specific number, with variable payouts.\n6 or 8- 9 to 1 payout. 4 or 10- 7 to 1. 2 or 12- 30 to 1. 3 or 11- 15 to 1. Craps- 7 to 1. 7- 4 to 1.\nField bets are the final one-roll bet. Rolling 3, 4, 9, 10, or 11 pays 1 to 1. Rolling 2 or 12 pays 2 to 1.\nPlace bets can be performed once the point is known. You're betting that a specific different point option will be rolled- this has 1 to 1 payout.\nThat's every bet in Craps! Have fun!");
    }

    public void optionsMenu(){

    }

    public void shooterScores(){
        currentDisplaySP("The shooter got the point!");
    }

    public void shooterSevenedOut(){
        currentDisplaySP("The shooter sevened out...");
    }

    public void push(){
        currentDisplaySP("Your bet is a push.");
    }

    public void oneRolLBetLoss(){
        currentDisplaySP("Your one-roll proposition failed...");
    }

    public void oneRollBetWin(){
        currentDisplaySP("You won your one-roll proposition!");
    }

    public void natural(){
        currentDisplaySP("It's a natural!");
    }

    public void craps(){
        currentDisplaySP("It's craps!");
    }

    public void shooterRolled(){
        currentDisplaySP("The shooter rolled a " + 5);
    }

    public void setTypeOfBet(){
        currentDisplaySP("What kind of bet do you want to make?");
    }

    public void comeOutRoll(){
        currentDisplaySP("Here's the come out roll...");
    }
}












