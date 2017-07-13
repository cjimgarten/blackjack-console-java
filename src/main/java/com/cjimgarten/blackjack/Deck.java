package com.cjimgarten.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by chris on 6/21/17.
 */
public class Deck extends ArrayList<Card> {

    /**
     * class for a deck of cards
     */

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
    public String toString() {
        String toString = "";
        for (Card c : this) {
            toString += c + "\n";
        }
        return toString;
    }

    // main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Shuffle first? (y/n) ");
        String shuffle = in.next();

        Deck myDeck = new Deck();
        if (shuffle.equals("y") || shuffle.equals("yes")) {
            myDeck.shuffle();
        }

        System.out.println("\nDeck:\n" + myDeck);
        System.out.println("Top card:\n" + myDeck.getTopCard());
    }
}
