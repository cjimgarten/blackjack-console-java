package cjimgarten;

/**
 * Created by chris on 6/21/17.
 */
public class Card {

    /**
     * class for a playing card
     */

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
    private String rank, suit;
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

    // get methods
    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isFaceUp() {
        return this.faceUp;
    }

    // swap the value of an Ace
    public void swapAceValue() {

        // ensure the card is an Ace
        if (!this.rank.equals(ACE)) {
            return;
        }

        // swap value
        if (this.value == ONE_VAL) {
            this.value = ELEVEN_VAL;
        } else {
            this.value = ONE_VAL;
        }
    }

    // to string method
    public String toString() {
        return "rank: " + this.rank + ", suit: " + this.suit + ", value: " + this.value + ", " +
                "faceUp: " + this.faceUp;
    }

    // main method
    public static void main(String[] args) {
        Card myCard = new Card();
        System.out.println(myCard);
        System.out.println(myCard.getRank());
        System.out.println(myCard.getSuit());
        System.out.println(myCard.getValue());
        System.out.println(myCard.isFaceUp());
    }
}
