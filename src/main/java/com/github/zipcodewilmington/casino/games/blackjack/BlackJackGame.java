package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;


public class BlackJackGame implements GameInterface { //, PlayerInterface {
    private Boolean isRunning = false;
    private PlayerInterface playerInt;
    Integer userBet;
    IOConsole input = new IOConsole();
    Integer winnings = 0;
    BlackJack bj;
    Player player;


    public BlackJackGame () {

    }

    public void add(PlayerInterface player) {
        this.playerInt = player;
    }


    public void remove(PlayerInterface player) {
        player = null;
    }


    public void run() {
        System.out.println("\u001B[36m============================================================");
        System.out.println("\u001B[36m=====                                                  =====");
        System.out.println("\u001B[36m=====                     WELCOME                      =====");
        System.out.println("\u001B[36m=====                       TO                         =====");
        System.out.println("\u001B[36m=====                    B L A C K                     =====");
        System.out.println("\u001B[36m=====                     J A C K                      =====");
        System.out.println("\u001B[36m=====                                                  =====");
        System.out.println("\u001B[36m============================================================");
        while(!isRunning) {
            // include betting range

            Integer userInput = input.getIntegerInput("\u001B[32m1. Start A Hand" + "\n" + "\u001B[31m2. Quit" + "\n");
            switch (userInput) {
                case 1:
                    BlackJack freshHand = new BlackJack();
                    bj = freshHand;
                    this.userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?"));
            //        subtractBetFromBalance(userBet);
            //        System.out.println("You bet " + player.getBalance());
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    public void startGame () {
        bj.givePlayerCard();
        System.out.println("Your starting card : " + bj.playersCurrentValue());
        System.out.println("Your second next card : " + bj.givePlayerCard());
        System.out.println("Hand value : " + bj.playersCurrentValue());
        if (bj.playersHand.get(0).equals(bj.playersHand.get(1))) {  // include conditional on starting blackjack!
            splitPlayer();
        } else {
            standardGame();
        }
    }

    public void standardGame () {
        boolean isWinner = false;
        while (!isWinner) {
            System.out.println("Your hand value " + bj.playersCurrentValue());
            Integer userChoice = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
            switch (userChoice) {
                case 1:
                    isWinner = checkStandardWinner(isWinner);
                    break;
                case 2:
                    bj.giveDealerCard();
                    System.out.println("The dealers first card : " + bj.dealersCurrentValue());
                    bj.giveDealerCard();
                    bj.dealersGame();
                    isWinner = true;
                    break;
            }
        }
    }

    public void splitPlayer () {
        Integer choice = input.getIntegerInput("1. Split" + "\n" + "2. No, I'll play this hand");
        if (choice.equals(2)) {
            standardGame();
        } else {    // include another betting portion for this hand
            splitHandRound();
        }
    }


    public CasinoAccount getArcadeAccount() {
        return null;
    }


    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        winnings = multiplier * 4;
        return winnings;
    }


    public void subtractBetFromBalance(Integer betAmount) {
        this.player.makeBet(betAmount);
    }


    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        this.player.setBalance(player.getBalance() + winnings);
    }

    private void splitPlayerHitsBlackJack(Integer splitBet) {
        System.out.println("BLACK JACK!!");
        calculateWinnings(3, splitBet);
        addMoneyToBalance(this.player, calculateWinnings(3, splitBet));
        standardGame();
    }

    private void splitPlayerBust(Integer splitBet) {
        System.out.println("Sorry bud, you got " + bj.splitPlayersCurrentValue() +
                ", you still have one more hand!");
        subtractBetFromBalance(splitBet);
        standardGame();
    }

    private boolean checkStandardWinner(boolean isWinner) {
        bj.givePlayerCard();
        System.out.println("Current hand value " + bj.playersCurrentValue());
        if(bj.playersCurrentValue() > 21) {
            System.out.println("Sorry bud, you got " + bj.playersCurrentValue() +
                    ", better luck next time");
            subtractBetFromBalance(userBet);
            isWinner = true;
        } else if (bj.playerHitsBlackJack()) {
            System.out.println("BLACK JACK!!");
            addMoneyToBalance(this.player, calculateWinnings(3, userBet));
            isWinner = true;
        }
        return isWinner;
    }

    private Integer secondHandBet() {
        Integer splitValue = bj.playersHand.get(1);
        bj.playersHandOnSplit.add(splitValue);
        bj.playersHand.set(1, 0);
        Integer splitBet = input.getIntegerInput("Please place your bet for the second hand");
        System.out.println("Your hand has been split! Current value " + bj.splitPlayersCurrentValue() + "\n" + "\n");
        return splitBet;
    }

    private void splitHandRound() {
        boolean isWinnerSecondHand = false;
        Integer splitBet = secondHandBet();
        while (!isWinnerSecondHand) {
            Integer userInput = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
            switch (userInput) {
                case 1:
                    bj.givePlayerCardOnSplit();
                    System.out.println("Current hand value " + bj.splitPlayersCurrentValue());
                    if (bj.splitPlayersCurrentValue() > 21) {
                        splitPlayerBust(splitBet);
                        isWinnerSecondHand = true;
                    } else if (bj.splitPlayerHitsBlackJack()) {
                        splitPlayerHitsBlackJack(splitBet);
                        isWinnerSecondHand = true;
                    }
                    break;
                case 2:
                    standardGame();
            }
        }
    }
}