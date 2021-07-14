package com.github.zipcodewilmington.casino;


public class Player implements PlayerInterface{

    String name;
    Integer balance;
    Integer currentBet = 0;
    CasinoAccount arcadeAccount;

    public Player(String name, Integer initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
    }

    public String getName() {
        return name;
    }


    public Integer getBalance() {
        return balance;
    }

    public void setCurrentBet(Integer currentBet) {
        this.currentBet = currentBet;
    }

    public void setBalance(Integer deposit) {
        this.balance = balance + deposit;
    }


    public Integer makeBet(Integer betAmount) {
        currentBet = betAmount;
        balance = balance - currentBet;
        return currentBet;
    }

    public Integer getCurrentBet() {
        return currentBet;
    }

    public CasinoAccount getArcadeAccount(){
        return this.arcadeAccount;
    }

}