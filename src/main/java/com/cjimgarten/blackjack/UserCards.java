package com.cjimgarten.blackjack;

/**
 * UserCards.java
 * a users cards
 */
public class UserCards extends PlayerCards {

    // fields
    private double bank;

    // constructor
    public UserCards() {
        this(1000.00);
    }

    public UserCards(double bank) {
        this.bank = roundToTwoDecimals(bank);
    }

    // methods
    public double getBank() {
        return this.bank;
    }

    public void deposit(double amount) {
        this.bank += amount;
        this.bank = roundToTwoDecimals(this.bank);
    }

    public void withdraw(double amount) {
        this.bank -= amount;
        this.bank = roundToTwoDecimals(this.bank);
    }

    private static double roundToTwoDecimals(double amount) {
        amount *= 100;
        amount = Math.round(amount);
        return amount / 100;
    }
}
