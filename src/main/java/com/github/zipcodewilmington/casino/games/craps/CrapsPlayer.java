package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;


public class CrapsPlayer implements GamblingPlayer {


    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }


    @Override
    public void increaseBet(float raise) {

    }

    @Override
    public void decreaseBet(float deposit) {

    }

    @Override
    public float amountWagered() {
        return 0;
    }

    @Override
    public float amountWon() {
        return 0;
    }

    @Override
    public float payOut() {
        return 0;
    }
}