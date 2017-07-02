package cjimgarten;

import java.util.Scanner;

/**
 * Created by chris on 6/25/17.
 */
public class Blackjack {

    /**
     * class for a blackjack game
     */

    // constants
    public static final int MAGIC_NUMBER = 21;

    // fields
    private Deck deck;
    private Player userHand;
    private Player dealerHand;

    // scanner for user input
    private Scanner in = new Scanner(System.in);

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

        // play the game
        do {

            // iteration of a single game

            System.out.println("Let's play\n");
            this.clearAndDeal();
            this.displayHands();
            this.userHits();
            this.dealerHits();

            int winner = this.evaluateHands();
            if (winner == 1) {
                System.out.println("\nYou win\n");
            } else if (winner == 2) {
                System.out.println("\nDealer wins\n");
            } else {
                System.out.println("\nTie\n");
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
            if (c.isFaceUp()) {
                System.out.println(c.getRank() + " of " + c.getSuit() + "s: " + c.getValue());
            } else {
                System.out.println("_");
            }
        }
        System.out.println("Value: " + this.userHand.getHandValue());

        // line break
        System.out.print("\n");

        // display the dealers hand
        this.sleep(500);
        System.out.println("Dealer hand:");
        for (Card c : this.dealerHand) {
            if (c.isFaceUp()) {
                System.out.println(c.getRank() + " of " + c.getSuit() + "s: " + c.getValue());
            } else {
                System.out.println("_");
            }
        }
        System.out.println("Value: " + this.dealerHand.getHandValue());
    }

    // user plays their hand
    public void userHits() {
        while (true) {
            System.out.print("\n");
            this.sleep(500);
            boolean hit = yesOrNo("Hit?");
            if (!hit) {
                break;
            }

            System.out.print("\n");
            this.userHand.addCard(this.deck.getTopCard(), true);
            this.displayHands();
        }
    }

    // dealer plays their hand
    public void dealerHits() {

        // dealer hits until 17 or higher
        this.dealerHand.flip(1);
        while (this.dealerHand.getHandValue() < 17) {
            this.dealerHand.addCard(this.deck.getTopCard(), true);
        }
        this.displayHands();
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

    // main method
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.start();
    }
}
