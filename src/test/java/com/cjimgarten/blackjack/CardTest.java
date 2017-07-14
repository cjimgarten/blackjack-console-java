package com.cjimgarten.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chris on 7/13/17.
 */
public class CardTest {

    private Card ace1;
    private Card ace2;
    private Card king;

    @Before
    public void before() {
        ace1 = new Card("Ace", "Spade", 11, false);
        ace2 = new Card("Ace", "Spade", 1, true);
        king = new Card("King", "Spade", 10, false);

    }

    @Test
    public void testInitialization() {
        assertTrue(ace1.getRank().equals("Ace"));
        assertTrue(ace1.getSuit().equals("Spade"));
        assertTrue(ace1.getValue() == 11);
        assertFalse(ace1.isFaceUp());
    }

    @Test
    public void testSetValue() {
        assertTrue(ace1.getValue() == 11);
        ace1.setValue(1);
        assertTrue(ace1.getValue() == 1);
    }

    @Test
    public void testSetFaceUp() {
        assertFalse(ace1.isFaceUp());
        ace1.setFaceUp(true);
        assertTrue(ace1.isFaceUp());
    }

    @Test
    public void testFlipFalse() {
        assertFalse(ace1.isFaceUp());
        ace1.flip();
        assertTrue(ace1.isFaceUp());
    }

    @Test
    public void testFlipTrue() {
        assertTrue(ace2.isFaceUp());
        ace2.flip();
        assertFalse(ace2.isFaceUp());
    }

    @Test
    public void testSwapAceValueAceEleven() {
        assertTrue(ace1.getValue() == 11);
        ace1.swapAceValue();
        assertTrue(ace1.getValue() == 1);
    }

    @Test
    public void testSwapAceValueAceOne() {
        assertTrue(ace2.getValue() == 1);
        ace2.swapAceValue();
        assertTrue(ace2.getValue() == 11);
    }

    @Test
    public void testSwapAceValueNotAce() {
        assertTrue(king.getValue() == 10);
        king.swapAceValue();
        assertTrue(king.getValue() == 10);
    }
}
