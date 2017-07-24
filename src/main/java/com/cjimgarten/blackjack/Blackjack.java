package com.cjimgarten.blackjack;

import java.util.Scanner;

/**
 * Created by chris on 6/25/17.
 */
public class Blackjack {

    /**
     * class for a game of blackjack
     */

    // constants
    public static final int MAGIC_NUMBER = 21;
    public static final String USER_WINS = "You Win :)";
    public static final String DEALER_WINS = "Dealer Wins :(";
    public static final String TIE = "Tie :/";

    // fields
    private Deck deck;
    private Player userHand;
    private Player dealerHand;

    // scanner for user input
    private static Scanner in = new Scanner(System.in);

    // constructor
    public Blackjack() {
        this.deck = new Deck();
        this.userHand = new Player();
        this.dealerHand = new Player();
    }

    // start the game
    public void start() {

        System.out.println("Welcome to Blackjack");

        // prompt the user if they're ready to play
        boolean ready = this.yesOrNo("Ready to play?");
        if (!ready) {
            System.out.println("Bye");
            System.exit(0);
        }

        this.deck.shuffle();
        boolean playAgain;

        // iteration of games
        do {

            this.checkDeckSize();
            System.out.println("\nLet's play\n");
            this.clearAndDeal();
            this.displayHands();

            // user plays their hand
            boolean userOverTwentyOne = this.userHits();
            if (userOverTwentyOne) {

                // user loses
                System.out.println("\n" + DEALER_WINS + "\n");
                playAgain = yesOrNo("Play again?");
                continue;
            }

            // dealer plays their hand
            boolean dealerOverTwentyOne = this.dealerHits();
            if (dealerOverTwentyOne) {

                //  user wins
                System.out.println("\n" + USER_WINS + "\n");
                playAgain = yesOrNo("Play again?");
                continue;
            }

            int winner = this.evaluateHands();
            if (winner == 1) {
                System.out.println("\n" + USER_WINS + "\n");
            } else if (winner == 2) {
                System.out.println("\n" + DEALER_WINS + "\n");
            } else {
                System.out.println("\n" + TIE + "\n");
            }

            playAgain = yesOrNo("Play again?");

        } while (playAgain);

        // farewell user
        System.out.println("Bye");
    }

    // if 'y' or 'yes' return true, else return false
    public boolean yesOrNo(String prompt) {
        boolean readyBool = false;
        System.out.println(prompt + " (y/n) ");
        String readyStr = in.next();
        if (readyStr.equals("y") || readyStr.equals("yes")) {
            readyBool = true;
        }
        return readyBool;
    }

    // check the number of cards in the deck
    public void checkDeckSize() {
        if (this.deck.size() < 15) {
            this.deck.clear();
            this.deck = new Deck();

            System.out.print("\n");
            String shuffling = "Shuffling...";
            for (char c : shuffling.toCharArray()) {
                System.out.print(c);
                this.sleep(250);
            }
            System.out.print("\n");
            this.deck.shuffle();
        }
    }

    // clear hands and deal a new hand
    public void clearAndDeal() {
        this.userHand.clear();
        this.userHand.addCard(this.deck.getTopCard(), true);
        this.userHand.addCard(this.deck.getTopCard(), true);

        this.dealerHand.clear();
        this.dealerHand.addCard(this.deck.getTopCard(), true);
        this.dealerHand.addCard(this.deck.getTopCard(), false);
    }

    // display hands
    public void displayHands() {

        // display the users hand
        this.sleep(500);
        System.out.println("Your hand:");
        for (Card c : this.userHand) {
            this.sleep(100);
            if (c.isFaceUp()) {
                System.out.println(c.getRank() + " of " + c.getSuit() + "s: " + c.getValue());
            } else {
                System.out.println("_");
            }
        }
        this.sleep(100);
        System.out.println("Value: " + this.userHand.getHandValue());

        // line break
        System.out.print("\n");

        // display the dealers hand
        this.sleep(500);
        System.out.println("Dealer hand:");
        for (Card c : this.dealerHand) {
            this.sleep(100);
            if (c.isFaceUp()) {
                System.out.println(c.getRank() + " of " + c.getSuit() + "s: " + c.getValue());
            } else {
                System.out.println("_");
            }
        }
        this.sleep(100);
        System.out.println("Value: " + this.dealerHand.getHandValue());
    }

    // user plays their hand
    public boolean userHits() {

        boolean overTwentyOne = false;
        while (true) {
            System.out.print("\n");
            this.sleep(500);
            boolean hit = yesOrNo("Hit?");
            System.out.print("\n");
            if (!hit) {
                break;
            }

            this.userHand.addCard(this.deck.getTopCard(), true);
            this.displayHands();

            // check if user is over 21
            if (this.userHand.getHandValue() > MAGIC_NUMBER) {
                overTwentyOne = true;
                break;
            }
        }

        return overTwentyOne;
    }

    // dealer plays their hand
    public boolean dealerHits() {

        // dealer hits until 17 or higher
        boolean overTwentyOne = false;
        this.dealerHand.flipCard(1);
        while (this.dealerHand.getHandValue() < 17) {
            this.dealerHand.addCard(this.deck.getTopCard(), true);
        }
        this.displayHands();

        // check if dealer is over 21
        if (this.dealerHand.getHandValue() > MAGIC_NUMBER) {
            overTwentyOne = true;
        }

        return overTwentyOne;
    }

    // return 1 if the user wins, 2 if the dealer wins, or 3 if they tie
    public int evaluateHands() {
        int winner;
        if (this.userHand.getHandValue() > this.dealerHand.getHandValue()) {
            winner = 1; // user wins
        } else if (this.userHand.getHandValue() < this.dealerHand.getHandValue()) {
            winner = 2; // dealer wins
        } else {
            winner = 3; // tie
        }
        return winner;
    }

    // return 1 if less than 21, 2 if equal to 21, or 3 if greater than 21
    public int checkHandValue(int handValue) {
        int status;
        if (handValue < MAGIC_NUMBER) {
            status = 1; // less than 21
        } else if (handValue == MAGIC_NUMBER) {
            status = 2; // equal to 21
        } else {
            status = 3; // greater than 21
        }
        return status;
    }

    // go to sleep
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
