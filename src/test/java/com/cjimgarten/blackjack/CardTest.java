package com.cjimgarten.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chris on 7/13/17.
 */
public class CardTest {

    private Card ace;
    private Card king;

    @Before
    public void before() {
        ace = new Card("Ace", "Spade", 11, false);
        king = new Card("King", "Spade", 10, false);

    }

    @Test
    public void testInitialization() {
        assertTrue(ace.getRank().equals("Ace"));
        assertTrue(ace.getSuit().equals("Spade"));
        assertTrue(ace.getValue() == 11);
        assertFalse(ace.isFaceUp());
    }

    @Test
    public void testSetValueAce() {
        assertTrue(ace.getValue() == 11);
        ace.setValue(1);
        assertTrue(ace.getValue() == 1);
    }

    @Test
    public void testSetValueNotAce() {
        assertTrue(king.getValue() == 10);
        king.setValue(1);
        assertFalse(king.getValue() == 1);
    }
}
