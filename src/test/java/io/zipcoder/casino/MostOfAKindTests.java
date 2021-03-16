package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MostOfAKindTests {

    @Test
    public void getPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 0;

        //When
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 5;

        //When
        yahtzee.addToPot(5);
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 0;
        yahtzee.addToPot(7);
        yahtzee.clearPot();

        //When
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDice() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        int result = yahtzee.rollDice();

        //Then
        Assert.assertTrue(result > 0 && result < 7);
    }

    @Test
    public void addToPlayerCount() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(3);
        int expected = 3;

        //When
        int actual = yahtzee.getPlayerCount();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerDealer() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(3);
        yahtzee.addToDealerCount(4);

        //When
        boolean actual = yahtzee.checkWinner();

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkWinnerPlayer() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(4);
        yahtzee.addToDealerCount(2);

        //When
        boolean actual = yahtzee.checkWinner();

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void makeDealerHand() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        yahtzee.makeDealerHand(5);
        int actual = yahtzee.getDealerHand().size();

        //Then
        Assert.assertEquals(5, actual);
    }

    @Test
    public void makePlayerHand() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        yahtzee.makePlayerHand(5);
        int actual = yahtzee.getPlayerHand().size();

        //Then
        Assert.assertEquals(5, actual);
    }
    
    @Test
    public void playerSecondRoll() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(4);
        yahtzee.playerDiceHand.add(3);
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(6);
        ArrayList<Integer> old = yahtzee.getPlayerHand();

        //When
        yahtzee.exchangePlayerDice(5);
        ArrayList<Integer> newHand = yahtzee.getPlayerHand();

        //Then
        Assert.assertNotEquals(old, newHand);
    }

    @Test
    public void dealerSecondRoll() {
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(1);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(5);
        ArrayList<Integer> oldHand = yahtzee.getDealerHand();

        //When
        yahtzee.exchangeDealerDice(2);
        ArrayList<Integer> newHand = yahtzee.getDealerHand();

        //Then
        Assert.assertNotEquals(oldHand, newHand);
    }

    @Test
    public void playerSecondRollIrrational() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(4);
        yahtzee.playerDiceHand.add(3);
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(6);
        ArrayList<Integer> old = yahtzee.getPlayerHand();

        //When
        yahtzee.exchangePlayerDice(3);
        ArrayList<Integer> newHand = yahtzee.getPlayerHand();

        //Then
        Assert.assertNotEquals(old, newHand);
    }

    @Test
    public void dealerSecondRollIrrational() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(1);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(5);
        ArrayList<Integer> oldHand = yahtzee.getDealerHand();

        //When
        yahtzee.exchangeDealerDice(5);
        ArrayList<Integer> newHand = yahtzee.getDealerHand();

        //Then
        Assert.assertNotEquals(oldHand, newHand);
    }

    @Test
    public void setGetPlayerMatchingNum() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.setPlayerMatchingNum(5);
        int expected = 5;

        //When
        int actual = yahtzee.getPlayerMatchingNum();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGetDealerMatchingNum() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.setDealerMatchingNum(2);
        int expected = 2;

        //When
        int actual = yahtzee.getDealerMatchingNum();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerNumOfMatches() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(5);
        yahtzee.playerDiceHand.add(3);
        yahtzee.playerDiceHand.add(6);
        int expected = 3;

        //When
        yahtzee.playerNumOfMatches(yahtzee.playerDiceHand);
        int actual = yahtzee.getPlayerCount();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDealerNumOfMatches() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(2);
        yahtzee.dealerHand.add(5);
        int expected = 4;

        //When
        yahtzee.dealerNumOfMatches(yahtzee.dealerHand);
        int actual = yahtzee.getDealerCount();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
