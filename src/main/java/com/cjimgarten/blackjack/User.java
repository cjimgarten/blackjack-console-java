package com.cjimgarten.blackjack;

/**
 * Created by chris on 7/25/17.
 */
public class User extends Player {

    /**
     * class for a users hand
     */

    // fields
    private double bank;

    // constructor
    public User() {
        this(1000.00);
    }

    public User(double bank) {
        this.bank = bank;
    }

    // methods
    public double getBank() {
        return this.bank;
    }

    public void deposit(double amount) {
        this.bank += amount;
    }

    public void withdraw(double amount) {
        this.bank -= amount;
    }

}
