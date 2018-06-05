package com.cjimgarten.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck.java
 * a deck of cards
 */
public class Deck extends ArrayList<Card> {

    // constants
    public static final int START_SIZE = 52;

    // array to hold rank values
    private static final String[] ranks = {
            Card.ACE, Card.KING, Card.QUEEN,
            Card.JACK, Card.TEN, Card.NINE,
            Card.EIGHT, Card.SEVEN, Card.SIX,
            Card.FIVE, Card.FOUR, Card.THREE,
            Card.TWO
    };

    // array to hold suit values
    private static final String[] suits = { Card.SPADE, Card.HEART, Card.CLUB, Card.DIAMOND };

    // array to hold numeric card values
    private static final int[] values = {
            Card.ELEVEN_VAL, Card.TEN_VAL, Card.TEN_VAL,
            Card.TEN_VAL, Card.TEN_VAL, Card.NINE_VAL,
            Card.EIGHT_VAL, Card.SEVEN_VAL, Card.SIX_VAL,
            Card.FIVE_VAL, Card.FOUR_VAL, Card.THREE_VAL,
            Card.TWO_VAL
    };

    // constructor
    public Deck() {
        super();
        Card c;
        for (int i = 0; i < START_SIZE; i++) {
            if (i < (START_SIZE / 4)) {
                c = new Card(ranks[i%13], suits[0], values[i%13]);
            } else if (i < (START_SIZE / 4 * 2)) {
                c = new Card(ranks[i%13], suits[1], values[i%13]);
            } else if (i < (START_SIZE / 4 * 3)) {
                c = new Card(ranks[i%13], suits[2], values[i%13]);
            } else {
                c = new Card(ranks[i%13], suits[3], values[i%13]);
            }
            this.add(c);
        }
    }

    // get the top card
    public Card getTopCard() {
        return this.remove(0);
    }

    // shuffle the deck
    public void shuffle() {
        Collections.shuffle(this);
    }

    // to string method
    @Override
    public String toString() {
        String toString = "";
        for (Card c : this) {
            toString += c + "\n";
        }
        return toString;
    }
}
