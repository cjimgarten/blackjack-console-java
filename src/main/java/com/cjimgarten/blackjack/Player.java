package com.cjimgarten.blackjack;

import java.util.ArrayList;

/**
 * Player class
 * class for a players hand
 */
public class Player extends ArrayList<Card> {

    // fields
    private int handValue;

    // constructor
    public Player() {
        this.handValue = 0;
    }

    // get method
    public int getHandValue() {
        return this.handValue;
    }

    // add a card to the hand
    public void addCard(Card c, boolean faceUp) {
        c.setFaceUp(faceUp);
        this.add(c);
        this.updateHandValue();
    }

    // flip a card in the hand
    public void flipCard(int index) {
        Card c = this.get(index);
        if (c.isFaceUp()) {
            c.setFaceUp(false);
        } else {
            c.setFaceUp(true);
        }
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
        boolean found = false;
        for (Card c: this) {
            if (c.isFaceUp() && c.getRank().equals(Card.ACE) && c.getValue() == Card.ELEVEN_VAL) {
                c.setValue(Card.ONE_VAL);
                found = true;
                break;
            }
        }
        return found;
    }

    // to string method
    @Override
    public String toString() {
        String toString = "";
        for (Card c : this) {
            toString += c + "\n";
        }
        toString += "handValue: " + this.handValue;
        return toString;
    }
}
