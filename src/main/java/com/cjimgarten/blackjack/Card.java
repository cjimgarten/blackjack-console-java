package com.cjimgarten.blackjack;

/**
 * Card class
 * class for a playing card
 */
public class Card {

    // rank constants
    public static final String ACE = "Ace";
    public static final String KING = "King";
    public static final String QUEEN = "Queen";
    public static final String JACK = "Jack";
    public static final String TEN = "Ten";
    public static final String NINE = "Nine";
    public static final String EIGHT = "Eight";
    public static final String SEVEN = "Seven";
    public static final String SIX = "Six";
    public static final String FIVE = "Five";
    public static final String FOUR = "Four";
    public static final String THREE = "Three";
    public static final String TWO = "Two";

    // suit constants
    public static final String SPADE = "Spade";
    public static final String HEART = "Heart";
    public static final String CLUB = "Club";
    public static final String DIAMOND = "Diamond";

    // value constants
    public static final int ELEVEN_VAL = 11;
    public static final int TEN_VAL = 10;
    public static final int NINE_VAL = 9;
    public static final int EIGHT_VAL = 8;
    public static final int SEVEN_VAL = 7;
    public static final int SIX_VAL = 6;
    public static final int FIVE_VAL = 5;
    public static final int FOUR_VAL = 4;
    public static final int THREE_VAL = 3;
    public static final int TWO_VAL = 2;
    public static final int ONE_VAL = 1;

    // fields
    private final String rank, suit;
    private int value;
    private boolean faceUp;

    // constructors
    public Card() {
        this(ACE, SPADE, ELEVEN_VAL, false);
    }

    public Card(String rank, String suit, int value) {
        this(rank, suit, value, false);
    }

    public Card(String rank, String suit, int value, boolean faceUp) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.faceUp = faceUp;
    }

    // getters and setters
    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {

        // only set the value if the card is an Ace
        if (!this.rank.equals(ACE)) {
            return;
        }
        this.value = value;
    }

    public boolean isFaceUp() {
        return this.faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    // to string method
    @Override
    public String toString() {
        return "rank: " + this.rank + ", suit: " + this.suit + ", value: " + this.value + ", " +
                "faceUp: " + this.faceUp;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Card) ) {
            return false;
        }

        Card card = (Card) obj;

        if (this.rank.equals(card.rank) &&
                this.suit.equals(card.suit) &&
                this.value == card.value &&
                this.faceUp == card.faceUp) {
            return true;
        }

        return false;
    }

}
