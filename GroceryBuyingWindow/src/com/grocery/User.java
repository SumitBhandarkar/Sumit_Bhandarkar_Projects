package com.grocery;

public class User {
    private String name;
    private Wallet wallet;

    public User(String name, double initialBalance) {
        this.name = name;
        this.wallet = new Wallet(initialBalance);
    }

    public Wallet getWallet() {
        return wallet;
    }
}
