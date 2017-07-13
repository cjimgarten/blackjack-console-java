package com.cjimgarten.blackjack;

import java.util.ArrayList;

/**
 * Created by chris on 6/25/17.
 */
public class Player extends ArrayList<Card> {

    /**
     * class for a players hand
     */

    // fields
    private int handValue;

    // constructors
    public Player() {
        this.handValue = 0;
    }

    // get method
    public int getHandValue() {
        return this.handValue;
    }

    // add a card to the hand
    public void addCard(Card c, boolean faceUp) {
        if (!c.isFaceUp() && faceUp) {
            c.flip();
        } else if (c.isFaceUp() && !faceUp) {
            c.flip();
        }
        this.add(c);
        this.updateHandValue();
    }

    // flip a card in the hand
    public void flip(int index) {
        this.get(index).flip();
        this.updateHandValue();
    }

    // update the value of the hand
    public void updateHandValue() {
        this.handValue = 0;
        for (Card c : this) {
            if (c.isFaceUp()) {
                this.handValue += c.getValue();
            }
        }

        if (this.handValue > 21) {
            boolean aceValueChanged = this.lookForAnAce();
            if (aceValueChanged) {
                this.updateHandValue();
            }
        }
    }

    // look for and swap the value of the first Ace found with a value of 11
    private boolean lookForAnAce() {
        boolean theThing = false;
        for (Card c: this) {
            if (c.isFaceUp() && c.getRank() == Card.ACE && c.getValue() == Card.ELEVEN_VAL) {
                c.swapAceValue();
                theThing = true;
                break;
            }
        }
        return theThing;
    }

    // to string method
    public String toString() {
        String toString = "";
        for (Card c : this) {
            toString += c + "\n";
        }
        toString += "handValue: " + this.handValue;
        return toString;
    }

    // main method
    public static void main(String[] args) {
        Player hand = new Player();

        System.out.println("Cards not face up:");
        for (int i = 0; i < 3; i++) {
            hand.addCard(new Card(), false);
        }
        System.out.println(hand);

        System.out.println("\nCards face up:");
        for (int i = 0; i < hand.size(); i++) {
            hand.flip(i);
        }
        System.out.println(hand);
    }
}
